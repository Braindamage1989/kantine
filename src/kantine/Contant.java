/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kantine;

/**
 * Write a description of class Contant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contant extends Betaalwijze
{
    /**
     * Constructor
     */
    public Contant(double saldo)
    {
        setSaldo(saldo);
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen)
    {
        if(tebetalen <= saldo) {
            saldo -= tebetalen;
            return true;
        }
        else {
            return false;
        }
    }
}
