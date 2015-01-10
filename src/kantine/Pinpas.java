/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package kantine;

/**
 * Write a description of class Pinpas here.
 * 
 * @author David Bor & Ronald Scholten 
 * @version 09-01-2015
 */
public class Pinpas extends Betaalwijze
{
    private double kredietlimiet;
    private Persoon persoon;

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
     * @param kredietlimiet een negatief getal die het minimum weergeeft van wat een persoon mag hebben
     */
    public void setKredietLimiet(double kredietlimiet)
    {
        if(kredietlimiet <= 0) {
            this.kredietlimiet = kredietlimiet;
        }
        else if(kredietlimiet > 0) {
            System.out.println("Please, enter only negative values.");
        }
    }
    
    /**
     * Methode om betaling af te handelen
     * @param tebetalen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException
    {
        if((saldo - kredietlimiet) >= tebetalen) {
            saldo -= tebetalen;
        }
        else {
            throw new TeWeinigGeldException();
        }
    }
}
