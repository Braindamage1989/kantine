public class Persoon {
  
    
    private int bsn;
    private String voornaam;
    private String achternaam;
    private int geboortejaar;
    private int geboortemaand;
    private int geboortedag;
    private char geslacht;
    
    /**
    * Verzameling van alle gegevens
    * Tot nu toch zonder goede check...
    */
    public Persoon(int bsnPersoon, String voornaamPersoon, String achternaamPersoon, int geboortejaarPersoon, int geboortemaandPersoon, int geboortedagPersoon, char geslachtPersoon) {
        bsn=bsnPersoon;
        voornaam=voornaamPersoon;
        achternaam=achternaamPersoon;
        setGeboortedatum(geboortejaarPersoon, geboortemaandPersoon, geboortedagPersoon);
        geboortemaand=geboortemaandPersoon;
        geboortedag=geboortedagPersoon;
        setGeslacht(geslachtPersoon);
    }
   
    /**
    * Setter voor geboortedatum
    * Met controle op juistheid van dag maand en jaar
    */
    public void setGeboortedatum(int tempGeboortejaar, int tempGeboortemaand, int tempGeboortedag) {
            boolean controle=true;
        if (tempGeboortejaar<1900 && tempGeboortejaar>2100) {
            controle=false;
        }
        if (tempGeboortemaand<0 && tempGeboortemaand>12) {
            controle=false;
        }
        if (tempGeboortedag<1){
            controle=false;
        }
        switch(tempGeboortemaand){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (tempGeboortedag>31) {
                    controle=false;
                }
                break;
            case 2:
                if (tempGeboortedag>28) {
                    controle=false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (tempGeboortedag>30) {
                    controle=false;
                }
                break;
        }
        if (controle==false) {
            tempGeboortedag=0;
            tempGeboortemaand=0;
            tempGeboortejaar=0;
        }
            geboortedag=tempGeboortedag;
            geboortemaand=tempGeboortemaand;
            geboortejaar=tempGeboortejaar;
    }
    
    public void setGeslacht(char charGeslacht) {
        if (charGeslacht=='m' || charGeslacht=='v'){
            // doe niks????
        }else {
            charGeslacht='o';
        }
        geslacht=charGeslacht;
    }
    
    /**
    * Getter voor bsn
    * @return bsn
    */
    public int getBsn(){
        return bsn;
    }
    
    /**
    * Getter voor voornaam
    * @return voornaam
    */
    public String getVoornaam() {
        return voornaam;
    }
    
    /**
    * Getter voor achternaam
    * @return achternaam
    */
    public String getAchternaam() {
        return achternaam;
    }
    
    /**
    * Getter voor geboortedatum
    * @return Geboortedatum
    */
    public String getGeboorteDatum() {
        String temp;
    if (geboortedag==0 && geboortemaand==0 && geboortejaar==0) {
        temp="Onbekend";
    } else {
        temp=geboortedag+"/"+geboortemaand+"/"+geboortejaar;
    }
    return temp;
    }
    
    /**
    * Getter voor geslacht
    * @return geslacht
    */
    public String getGeslacht(){
        String stringgeslacht;
        if (geslacht=='m'){
            stringgeslacht="Man";
        }else if(geslacht=='v'){
            stringgeslacht="Vrouw";
        }else{
            stringgeslacht="Onbekend";
        }
        return stringgeslacht;
    }
   
  /**
   * Methode om dienblad te koppelen aan een persoon
   * @param dienblad
   */  
  public void pakDienblad(Dienblad) {
    //method body omitted
  } 

  /**
   * Methode om artikel te pakken en te plaatsen op het dienblad
   * @param artikel
   */
  public void pakArtikel(Artikel artikel) {
    //method body omitted
  }

  /**
   * Methode om de totaalprijs van de artikelen 
   * op dienblad dat bij de persoon hoort uit te rekenen
   * @return De totaalprijs
   */
  public double getTotaalPrijs() {
    //method body omitted
  } 

  /**
   * Methode om het aantal artikelen op dienblad dat bij de 
   * persoon hoort te tellen
   * @return Het aantal artikelen
   */
  public int getAantalArtikelen() {
    //method body omitted    
  }
}
