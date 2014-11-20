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
    
    public Artikel(String naamArtikel, int prijsArtikel) 
    {
    	naam = naamArtikel;
    	prijs = prijsArtikel;
    }
    
    public void setNaam(String naamArtikel)
    {
    	naam = naamArtikel;
    }
    
    public void setPrijs(int prijsArtikel)
    {
    	prijs = prijsArtikel;
    }
    
    public String getNaam()
    {
    	return naam;
    }
    
    public int getPrijs()
    {
    	return prijs;
    }
    
    public void drukAf()
    {
    	System.out.println(naam + " Prijs: " + prijs);
    }
    
}
