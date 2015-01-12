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
public class Student extends Persoon
{
    private String studentnummer;
    private String studierichting;


    public Student(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String studentnummer, String studierichting)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.studentnummer = studentnummer;
        this.studierichting = studierichting;
    }
    
    public void setStudentnummer(String studentnummer)
    {
        this.studentnummer = studentnummer;
    }
    
    public void setStudierichting(String studierichting)
    {
        this.studierichting = studierichting;
    }
    
    public String getStudentnummer()
    {
        return studentnummer;
    }
    
    public String getStudierichting()
    {
        return studierichting;
    }
    
    public String toString()
    {
        return super.toString() +
               "Studentnummer: " + studentnummer + "\n" +
               "Studierichting: " + studierichting;
    }
}