package kantine;

/**
* Een subklasse voor Persoon die alle
* gegevens van docenten bevat.
* 
* @author Ronald Scholten & David Bor
* @version 12-01-2014
*/
public class Docent extends Persoon implements KortingskaartHouder
{
    private String afkorting;
    private String afdeling;

    /**
     * Constructor
     */
    public Docent(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String afkorting, String afdeling)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.afkorting = afkorting;
        this.afdeling = afdeling;
    }
    
    /**
     * Een setter om de afdeling van een docent te setten
     */
    public void setAfdeling(String afdeling)
    {
        this.afdeling = afdeling;
    }
    
    /**
     * Een setter om een afkorting van een docent te setten
     */
    public void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    /**
     * Een getter voor het kortingspercentage van een kantinemedewerker
     */
    public double geefKortingsPercentage()
    {
        return 0.25;
    }

    /**
     * Een getter om te bepalen of er een maximum is
     */
    public boolean heeftMaximum()
    {
        return true;
    }

    /**
     * Een getter die het maximum terug geeft, 0.0 betekend geen limiet
     */
    public double geefMaximum()
    {
        return 1.0;
    }

    /**
     * Een getter die de afdeling ophaalt
     */
    public String getAfdeling()
    {
        return afdeling;
    }
    
    /**
     * Een getter die een afkorting van de docent geeft
     */
    public String getAfkorting()
    {
        return afkorting;
    }
    
    /**
     * Override van toString() voor docent
     */
    public String toString()
    {
        return super.toString() +
               "Afdeling: " + afdeling + "\n" +
               "Afkorting: " + afkorting;
    }
}
