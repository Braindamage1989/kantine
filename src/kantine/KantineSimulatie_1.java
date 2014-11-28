package kantine;

public class KantineSimulatie {
  private Kantine kantine;

  /**
   * Constructor
   */
  public KantineSimulatie() {
    kantine=new Kantine();
  }

  /**
   * Deze methode simuleert een aantal dagen in het 
   * verloop van de kantine
   * @param dagen
   */
  public void simuleer(int dagen) {
      int dag = 1;
    // for lus voor dagen
    for(int i=0;i<dagen;i++) {
      // per dag nu even vast 10+i personen naar binnen
      // laten gaan, wordt volgende week veranderd
      // for lus voor personen
      for(int j=0;j<10+i;j++){
        kantine.loopPakSluitAan();
      }
      System.out.println("Resultaten dag " + dag +"");
      
      kantine.verwerkRijVoorKassa();
      System.out.println("Aantal artikelen: "+ kantine.aantalArtikelen() +"");
      System.out.println("Hoeveelheid geld van kassa: "+ kantine.hoeveelheidGeldInKassa() +"");
      kantine.resetKassa();
      dag++;
    }
  }
}
