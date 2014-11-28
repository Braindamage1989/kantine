package kantine;

/**
* Een klasse die informatie over kassa's bijhoud.
* Dit word een onderdeel van een grotere applicatie.
* 
* @author Ronald Scholten & David Bor
* @version 28-11-2014
*/

public class Kassa { 
	private Kassarij kassarij;
	private int aantalGepasseerdeArtikelen;
	private double totaalInKassa;
	
	/**
	 * Constructor
	 */
	public Kassa(Kassarij kassarij) {
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
		aantalGepasseerdeArtikelen += persoon.getAantalArtikelen();
		totaalInKassa += persoon.getTotaalPrijs();
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

