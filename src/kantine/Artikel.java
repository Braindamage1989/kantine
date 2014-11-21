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
public class Artikel {
    private String naam;
    private int prijs;
    
    /**
     * De naam en prijs zetten als het object
     * geconstrueerd word.
     */
    public Artikel(String naamArtikel, int prijsArtikel) 
    {
    	naam = naamArtikel;
    	prijs = prijsArtikel;
    }
    
    /**
     * Zet een naam voor het artikel.
     */
    public void setNaam(String naamArtikel)
    {
    	naam = naamArtikel;
    }
    
    /**
     * Zet de prijs van het artikel.
     */
    public void setPrijs(int prijsArtikel)
    {
    	prijs = prijsArtikel;
    }
    
    /**
     * Return de naam van het artikel.
     */
    public String getNaam()
    {
    	return naam;
    }
    
    /**
     * Return de prijs van het artikel.
     */
    public int getPrijs()
    {
    	return prijs;
    }
    
    public void drukAf()
    {
    	System.out.println(naam + " Prijs: " + prijs);
    }
    
}
