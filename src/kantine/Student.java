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


    public Student(int bsn, String voornaam, String achternaam, int geboortejaar, int geboortemaand, int geboortedag, char geslacht, String studentnummer)
    {
        super(bsn, voornaam, achternaam, geboortejaar, geboortemaand, geboortedag, geslacht);
        this.studentnummer = studentnummer;
    }
    
    public String getStudentnummer()
    {
        return studentnummer;
    }
    
    public void getStudentnummer(String studentnummer)
    {
        this.studentnummer = studentnummer;
    }
}