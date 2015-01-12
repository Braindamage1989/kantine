/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package kantine;

/**
 * Write a description of class Contant here.
 * 
 * @author David Bor & Ronald Scholten 
 * @version 09-01-2015
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
     * @param tebetalen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException
    {
        double restSaldo = saldo - tebetalen;
        if(restSaldo >= 0) {
            saldo -= tebetalen;
        }
        else {
            throw new TeWeinigGeldException("Saldo ontoereikend./nHet tekort is: " + restSaldo);
        }
    }
}
