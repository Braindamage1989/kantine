package kantine;  

import java.util.ArrayList;

/**
 * Een klasse die informatie over pe
 * Dit word een onderdeel van een grotere applicatie.
 * 
 * @author David Bor & Ronald Scholten 
 * @version 09-01-2015
 */

public class Persoon
{ 
        private int bsn;
        private String voornaam;
        private String achternaam;
        private int geboortejaar;
        private int geboortemaand;
        private int geboortedag;
        private char geslacht;
        private Dienblad dienblad;
        private Betaalwijze betaalwijze;
    
    /**
    * Een constructor met als parameters persoongegevens
    */
    public Persoon(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht)
    {
        setBsn(bsn);
        setVoornaam(voornaam);
        setAchternaam(achternaam);
        setGeboortedatum(geboortejaar, geboortemaand, geboortedag);
        setGeslacht(geslacht);
        dienblad = null;
    }
    
    /**
    * Lege constuctor
    */
    public Persoon()
    {
        bsn = 0;
        voornaam = "";
        achternaam = "";
        setGeboortedatum(0, 0, 0);
        geslacht = 'o';
        dienblad = null;
    }
    
    /**
    * Setter voor bsn
    * @param bsn
    */
    public void setBsn(int bsn)
    {
        this.bsn = bsn;
    }
     
    /**
    * Setter voor voornaam 
    * @param voornaam
    */
    public void setVoornaam(String voornaam)
    {
        this.voornaam = voornaam;
    }
     
    /**
    * Setter voor achternaam 
    * @param achternaam
    */
    public void setAchternaam(String achternaam)
    {
        this.achternaam = achternaam;
    }
     
    /**
    * Setter voor geboortedatum
    * Met controle op juistheid van dag maand en jaar
    * @param geboortejaar
    * @param geboortemaand
    * @param geboortedag
    */
    public void setGeboortedatum(int geboortejaar, int geboortemaand, int geboortedag)
    {
            boolean controle = true;
        if (geboortejaar < 1900 || geboortejaar > 2100) {
            controle = false;
        }
        if (geboortemaand < 0 || geboortemaand > 12) {
            controle = false;
        }
        if (geboortedag < 1) {
            controle = false;
        }
        switch(geboortemaand){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (geboortedag > 31) {
                    controle = false;
                }
                break;
            case 2:
                /* 
                * Controleren of een jaar deelbaar door 400 is,
                * of een jaar deelbaar door 100 en als dit wil vervolgens kijken of een jaar deelbaar is door 4,
                * om te bepalen of een jaar een schrikkeljaar is.
                */
                if ((geboortejaar % 400) == 0 || ((geboortejaar % 100 != 0) && geboortejaar % 4 == 0)){
                    if (geboortedag > 29) {
                       controle = false;
                    }
                }
                else if (geboortedag > 28) {
                        controle = false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (geboortedag > 30) {
                    controle = false;
                }
                break;
        }
        if (controle) {
            this.geboortedag = geboortedag;
            this.geboortemaand = geboortemaand;
            this.geboortejaar = geboortejaar;
        }
        else {
            this.geboortedag = 0;
            this.geboortemaand = 0;
            this.geboortejaar = 0;
        }
    }
    
    /**
    * Set het geslacht, is het geslacht niet geldig dan wordt deze op 'o' gezet
    * @param geslacht
    */
    public void setGeslacht(char geslacht)
    {
        if (geslacht == 'm' || geslacht == 'v'){
            this.geslacht = geslacht;
        }
        else {
            this.geslacht = 'o';
        }
    }
    
    /**
     * Setter voor betaalwijze
     * @param betaalwijze
     */
    public void setBetaalwijze(Betaalwijze betaalwijze)
    {
        this.betaalwijze = betaalwijze;
    }
    
    /**
    * Getter voor bsn
    * @return bsn
    */
    public int getBsn()
    {
        return bsn;
    }
    
    /**
    * Getter voor voornaam
    * @return voornaam
    */
    public String getVoornaam()
    {
        return voornaam;
    }
    
    /**
    * Getter voor achternaam
    * @return achternaam
    */
    public String getAchternaam()
    {
        return achternaam;
    }
    
    /**
    * Getter voor geboortedatum
    * @return geboortedatum (of onbekend)
    */
    public String getGeboorteDatum()
    {
        String temp;
	    if (geboortedag == 0 && geboortemaand == 0 && geboortejaar == 0) {
	        temp = "Onbekend";
	    }
	    else {
	        temp = geboortedag+"/"+geboortemaand+"/"+geboortejaar;
	    }
	    return temp;
    }
    
    /**
    * Getter voor geslacht
    * @return geslacht (of "Onbekend")
    */
    public String getGeslacht()
    {
        String stringgeslacht;
        if (geslacht == 'm'){
            stringgeslacht="Man";
        }
        else if (geslacht == 'v') {
            stringgeslacht = "Vrouw";
        }
        else {
            stringgeslacht = "Onbekend";
        }
        return stringgeslacht;
    }

    /**
     * Getter voor betaalwijze
     * @return betaalwijze
     */
    public Betaalwijze getBetaalwijze()
    {
        return betaalwijze;
    }
    
    /**
     * Getter voor dienblad
     * @return Dienblad
     */
    public Dienblad getDienblad() 
    {
        return dienblad;
    }
    
    /**
    * Druk alle gegevens af.
    */
    public void drukAf()
    {
        toString();
    }
    
    public String toString()
    {
        return  "BSN: " + bsn + "\n" +
                "Voornaam: " + voornaam + "\n" +
                "Achternaam: " + achternaam + "\n" +
                "Geboortedatum: " + getGeboorteDatum() + "\n" +
                "Geslacht: " + getGeslacht();
    }

    /**
    * Methode om dienblad te koppelen aan een persoon
    * @param dienblad
    */
    public void pakDienblad(Dienblad dienblad) 
    {
        this.dienblad = dienblad; 
    }
    
    public boolean equals(Object object)
    {
        if(this == object) {
            return true;
        }

        if(!(object instanceof Persoon)) {
            return false;
        }

        Persoon other = (Persoon) object;
        return bsn == other.bsn;
    }

    
}
