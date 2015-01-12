/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kantine;

/**
 *
 * @author R
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    private String afkorting;
    private String afdeling;


    public Docent(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String afkorting, String afdeling)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    public double geefKortingsPercentage()
    {
        return 0.25;
    }

    public boolean heeftMaximum()
    {
        return true;
    }

    public double geefMaximum()
    {
        return 1.0;
    }

    
    public String getAfdeling()
    {
        return afdeling;
    }
    
    public String getAfkorting()
    {
        return afkorting;
    }
    
    public String toString()
    {
        return "Afdeling: " + afdeling + "\n" +
               "Afkorting: " + afkorting;
    }
    
    public void drukAf(){
        super.toString();
        toString();
    }
}
