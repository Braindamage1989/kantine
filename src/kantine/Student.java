package kantine;

/**
* Een subklasse voor Persoon die alle
* gegevens van studenten bevat.
* 
* @author Ronald Scholten & David Bor
* @version 12-01-2014
*/
public class Student extends Persoon
{
    private String studentnummer;
    private String studierichting;

    /**
    * Constructor
    */
    public Student(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String studentnummer, String studierichting)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }
    
    /**
     * Setter om een studentnummer te setten
     */
    public void setStudentnummer(String studentnummer)
    {
        this.studentnummer = studentnummer;
    }
    
    /**
     * Setter om een studierichting aan te geven
     */
    public void setStudierichting(String studierichting)
    {
        this.studierichting = studierichting;
    }
    
    /**
     * Getter voor het verkrijgen van een studentnummer
     */
    public String getStudentnummer()
    {
        return studentnummer;
    }
    
    /**
     * Getter voor het verkrijgen van een studierichting
     */
    public String getStudierichting()
    {
        return studierichting;
    }
    
    /**
     * Override van toString() voor docent
     */
    public String toString()
    {
        return super.toString() +
               "Studentnummer: " + studentnummer + "\n" +
               "Studierichting: " + studierichting;
    }
}