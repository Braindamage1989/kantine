package kantine;

/**
* Een subklasse voor Persoon die alle
* gegevens van kantinemedewerkers bevat.
* 
* @author Ronald Scholten & David Bor
* @version 12-01-2014
*/

public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private String medewerkernummer;
    private boolean magAchterKassa;

    /**
    * Constructor
    */
    public KantineMedewerker(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String medewerkernummer, boolean magAchterKassa)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.medewerkernummer = medewerkernummer;
        this.magAchterKassa = magAchterKassa;
    }
    
    /**
     * Een setter om te bepalen of een kantinemedewerker achter de kassa mag
     */
    public void setMagAchterKassa(boolean magAchterKassa)
    {
        this.magAchterKassa = magAchterKassa;
    }
    
    /**
     * Een setter om een medewerkernummer in te stellen
     */
    public void setMedewerkernummer(String medewerkernummer)
    {
        this.medewerkernummer = medewerkernummer;
    }
    
    /**
     * Een getter voor het kortingspercentage van een kantinemedewerker
     */
    public double geefKortingsPercentage()
    {
        return 0.35;
    }
    
    /**
     * Een getter om te bepalen of er een maximum is
     */
    public boolean heeftMaximum()
    {
        return false;
    }

    /**
     * Een getter die het maximum terug geeft, 0.0 betekend geen limiet
     */
    public double geefMaximum()
    {
        return 0.0;
    }
    
    /**
     * Een getter voor medewerkernummer
     */
    public String getMedewerkernummer()
    {
        return medewerkernummer;
    }
    
    /**
     * Een getter om te zien of iemand achter de kassa mag
     */
    public boolean getMagAchterKassa()
    {
        return magAchterKassa;
    }
    
    /**
     * Override van toString() voor kantinemedewerker
     */
    public String toString()
    {
        return super.toString() +
               "Medewerkernummer: " + medewerkernummer + "\n" +
               "Mag achter de kassa? " + magAchterKassa;
    }
}