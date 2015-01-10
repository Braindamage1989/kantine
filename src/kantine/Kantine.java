package kantine;

/**
* Een klasse die aan de hand van andere klassen
* een nabootsing maakt van een kantine.
* 
* @author Ronald Scholten & David Bor
* @version 05-12-2014
*/
public class Kantine 
{
    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    
    /**
	  * Constructor voor het direct setten van het aanbod
	  */
    public Kantine (String[] naam, double[] prijs, int[] aantal)
    {
    	kassarij = new KassaRij();
    	kassa = new Kassa(kassarij);
    	setKantineAanbod(naam, prijs, aantal);
    }
  
    /**
     * Lege constructor
     */
    public Kantine ()
    {
    	kassarij = new KassaRij();
    	kassa = new Kassa(kassarij);
    	kantineaanbod = null;
    }
    
    /**
     * Deze methode set het kantineaanbod aan de hand van
     * een gegeven aanbod.
     * @param kantineaanbod
     */
    public void setKantineAanbod(KantineAanbod kantineaanbod)
    {
    	this.kantineaanbod = kantineaanbod;
    }
  
    /**
     * Deze methode set het kantineaanbod aan de hand van
     * ingevoerde arrays. De ingevoerden arrays moeten 
     * een gelijk aantal waarden bevatten.
     * @param array(String) van artikelnamen
     * @param array(double) van prijzen
     * @param array(int) van aantallen
     */
    public void setKantineAanbod(String[] naam, double[] prijs, int[] aantal)
    {
    	kantineaanbod = new KantineAanbod(naam, prijs, aantal);
    }
  
    /**
     * Deze methode geeft de kassa van de kantine.
     * @return kassa
     */
    public Kassa getKassa() 
    {
    	return kassa;
    }
    
    /**
     * Deze methode geeft het kantineaanbod van de kantine.
     * @return kantineaanbod
     */
    public KantineAanbod getKantineAanbod()
    {
    	return kantineaanbod;
    }
    
    /**
     * In deze methode wordt een Persoon en Dienblad
     * gemaakt en aan elkaar
     * gekoppeld. Maak twee Artikelen aan en plaats 
     * deze op het dienblad.   
     * Tenslotte sluit de Persoon zich aan bij de rij 
     * voor de kassa.
  	public void loopPakSluitAan() 
  	{
    	Persoon persoon = new Persoon();
    	Dienblad dienblad = new Dienblad();
    	
    	Artikel artikel1 = new Artikel("Unox Worst", 2.00);
    	Artikel artikel2 = new Artikel("Goedkoop Broodje", 0.50);
    	
    	persoon.pakDienblad(dienblad);
    	
    	dienblad.voegToe(artikel1);
    	dienblad.voegToe(artikel2);
            	
    	kassarij.sluitAchteraan(persoon);
  	}
     */
  
    /**
     * In deze methode kiest een Persoon met een dienblad
     * de artikelen in artikelnamen.
     * @param persoon
     * @param artikelnamen
     */
    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen)
    {
    	Dienblad dienblad = persoon.getDienblad();
    	for (String artikelnaam : artikelnamen) {
    		Artikel artikel = kantineaanbod.getArtikel(artikelnaam);
    		dienblad.voegToe(artikel);
    	}
    	kassarij.sluitAchteraan(persoon);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() throws TeWeinigGeldException
    {
    	while(kassarij.erIsEenRij()) {
    		kassa.rekenAf(kassarij.eerstePersoonInRij());
    	}
    }
}
