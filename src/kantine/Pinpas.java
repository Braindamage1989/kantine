/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kantine;

/**
 * Write a description of class Pinpas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinpas extends Betaalwijze
{
    private double kredietlimiet;

    /**
     * Constructor
     */
    public Pinpas(double saldo, double kredietlimiet)
    {
        setSaldo(saldo);
        setKredietLimiet(kredietlimiet);
    }

    /**
     * Methode om krefietlimiet te zetten
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet)
    {
        this.kredietlimiet = kredietlimiet;
    }
    
    /**
     * Methode om betaling af te handelen
     */
    public boolean betaal(double tebetalen)
    {
        if((saldo - tebetalen) <= kredietlimiet) {
            saldo -= tebetalen;
            return true;
        }
        else {
            return false;
        }
    }
}
