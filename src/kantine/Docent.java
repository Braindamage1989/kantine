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
public class Docent extends Persoon
{
    private String afkorting;
    private String afdeling;


    public Docent(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String afkorting, String afdeling)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    
    public String getAfdeling()
    {
        return afdeling;
    }
    
    public String getAfkorting()
    {
        return afkorting;
    }
    
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    public void drukAf()
    {
        System.out.println("Afdeling: " + afdeling);
        System.out.println("Afkorting: " + afkorting);
    }
}
