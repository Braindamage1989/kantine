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
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private String medewerkernummer;
    private boolean magAchterKassa;


    public KantineMedewerker(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String medewerkernummer, boolean magAchterKassa)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.medewerkernummer = medewerkernummer;
        this.magAchterKassa = magAchterKassa;
    }
    
    public void setMagAchterKassa(boolean magAchterKassa)
    {
        this.magAchterKassa = magAchterKassa;
    }
    
    public void setMagAchterKassa(String medewerkernummer)
    {
        this.medewerkernummer = medewerkernummer;
    }
    
    public double geefKortingsPercentage()
    {
        return 0.35;
    }

    public boolean heeftMaximum()
    {
        return false;
    }

    public double geefMaximum()
    {
        return 0.0;
    }
    
    public String getMedewerkernummer()
    {
        return medewerkernummer;
    }
    
    public boolean getMagAchterKassa()
    {
        return magAchterKassa;
    }
    
    public String toString()
    {
        return "Medewerkernummer: " + medewerkernummer + "\n" +
               "Mag achter de kassa? " + magAchterKassa;
    }
    
    public void drukAf(){
        super.toString();
        toString();
    }
}