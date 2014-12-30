package kantine;

import java.util.Iterator;

/**
* Een klasse die informatie over kassa's bijhoud.
* Dit word een onderdeel van een grotere applicatie.
* 
* @author Ronald Scholten & David Bor
* @version 28-11-2014
*/

public class Kassa { 
	private KassaRij kassarij;
    private Dienblad dienblad;
	private int aantalGepasseerdeArtikelen;
	private double totaalInKassa;
	
	/**
	 * Constructor
	 */
	public Kassa(KassaRij kassarij) {
		this.kassarij = kassarij;
		aantalGepasseerdeArtikelen = 0;
		totaalInKassa = 0.0;
	}
	
	/**
	 * vraag het aantal artikelen en de totaalprijs op.
	 * De implementatie wordt later vervangen 
	 * door een echte betaling door de persoon. 
	 * @param persoon die moet afrekenen
	 */
	public void rekenAf(Persoon persoon) {
            Artikel artikel;
            double tebetalen = 0.0;
            int aantalArtikelen = 0;
            double maximaleKorting = 0.0;
            double kortingsPercentage = 0.0;
            boolean heeftMaximum = false;

            
            dienblad = persoon.getDienblad();
            
            if(persoon instanceof KortingskaartHouder) {
                KortingskaartHouder kortingskaartHouder = (KortingskaartHouder) persoon;
                kortingsPercentage = kortingskaartHouder.geefKortingsPercentage();
                heeftMaximum = kortingskaartHouder.heeftMaximum();
                
                if(heeftMaximum) {
                    maximaleKorting = kortingskaartHouder.geefMaximum();
                }
            }
            
            Iterator<Artikel> artikelen = dienblad.getArtikelen();
            
            while(artikelen.hasNext()) {
                double korting;
                double artikelPrijs;
                
                artikel = artikelen.next();
                artikelPrijs = artikel.getPrijs();
                korting = artikel.getPrijs() * kortingsPercentage;
                if(heeftMaximum) {
                    if(korting <= maximaleKorting) {
                        maximaleKorting -= korting;
                        artikelPrijs -= korting;
                    }
                    else {
                        artikelPrijs -= maximaleKorting;
                        maximaleKorting -= maximaleKorting;
                    }
                }
                else {
                    artikelPrijs -= korting;
                }
                
                tebetalen += artikelPrijs;
                aantalArtikelen++;
            }
            
            if(!persoon.getBetaalwijze().betaal(tebetalen)) {
                totaalInKassa += tebetalen;
                aantalGepasseerdeArtikelen += aantalArtikelen;
            }
            else{
                System.out.println("U heeft onvoldoende saldo of krediet.");
                System.out.println("Kom terug wanneer u wel genoeg geld heeft!");
                System.out.println("Nog een fijne dag verder en tot ziens.");
            }
	}
	
	/**
	 * Geeft het aantal artikelen dat de kassa 
	 * heeft gepasseerd, 
	 * vanaf het moment dat de methode resetKassa 
	 * is aangeroepen.
	 * @return aantal artikelen
	 */
	public int aantalArtikelen() {
            return aantalGepasseerdeArtikelen;
	}
	
	/**
	 * Geeft het totaalbedrag van alle artikelen die
	 * de kassa zijn gepasseerd, vanaf het moment dat de methode
	 *resetKassa 
	 * is aangeroepen.
	 * @return hoeveelheid geld in de kassa
	 */
	public double hoeveelheidGeldInKassa() {
		return totaalInKassa;
	}
	
	/**
	 * reset de waarden van het aantal gepasseerde artikelen en 
	 * de totale hoeveelheid geld in de kassa.
	 */
	public void resetKassa() {
		aantalGepasseerdeArtikelen = 0;
		totaalInKassa = 0;
	}
}
