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
    // for lus voor dagen
    for(int i=0;i<dagen;i++) {
      // per dag nu even vast 10+i personen naar binnen
      // laten gaan, wordt volgende week veranderd
      // for lus voor personen
      for(int j=0;j<10+i;j++){
        kantine.loopPakSluitAan();
      }

      kantine.verwerkRijVoorKassa();
      System.out.println(kantine.aantalArtikelen());
      System.out.println(kantine.hoeveelheidGeldInKassa());
      kantine.resetKassa();
    }
  }
}
