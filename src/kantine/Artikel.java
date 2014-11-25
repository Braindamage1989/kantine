/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kantine;

/**
 * Een klasse die informatie over artikelen bijhoud.
 * Dit word een onderdeel van een grotere applicatie.
 * 
 * @author David Bor & Ronald Scholten
 * @version 25-11-2014
 */
public class Artikel
{
    private String naam;
    private int prijs;
    
    /**
     * De naam en prijs zetten als het object
     * geconstrueerd word.
     */
    public Artikel(String naam, int prijs) 
    {
    	this.naam = naam;
    	this.prijs = prijs;
    }
    
    /**
    * Lege constructor
    */
    public Artikel() 
    {
    }
    
    /**
     * Zet een naam voor het artikel.
     */
    public void setNaam(String naam)
    {
    	this.naam = naam;
    }
    
    /**
     * Zet de prijs van het artikel.
     */
    public void setPrijs(int prijs)
    {
    	this.prijs = prijs;
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
