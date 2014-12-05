package kantine;

/**
* Een klasse die aan de hand van andere klassen
* een nabootsing maakt van een kantine.
* 
* @author Ronald Scholten
* @version 28-11-2014
*/

public class Kantine {
    private Kassa kassa;
    private Kassarij kassarij;
    private KantineAanbod kantineaanbod;
    
  /**
   * Constructor
   */
  public Kantine (String[] naam, double[] prijs, int[] aantal)
  {
    kassarij = new Kassarij();
    kassa = new Kassa(kassarij);
    setKantineAanbod(naam, prijs, aantal);
  }
  
  public Kassa getKassa() {
    return kassa;
  }

  /**
   * In deze methode wordt een Persoon en Dienblad
   * gemaakt en aan elkaar
   * gekoppeld. Maak twee Artikelen aan en plaats 
   * deze op het dienblad.   
   * Tenslotte sluit de Persoon zich aan bij de rij 
   * voor de kassa.
  public void loopPakSluitAan() {
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
  * @artikelnamen
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
  public void verwerkRijVoorKassa() 
  {
    while(kassarij.erIsEenRij()) {
        kassa.rekenAf(kassarij.eerstePersoonInRij());
    }
  }
  
  public KantineAanbod getKantineAanbod()
  {
    return kantineaanbod;
  }
  
  public void setKantineAanbod(String[] naam, double[] prijs, int[] aantal)
  {
    kantineaanbod = new KantineAanbod(naam, prijs, aantal);
  }
      
}
