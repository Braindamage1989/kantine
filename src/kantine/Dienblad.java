package kantine;

import java.util.Stack;

/**
* Een klasse die een dienblad simuleert
* waar artikelen op kunnen worden gezet.
* 
* @author Ronald Scholten & David Bor
* @version 28-11-2014
*/

public class Dienblad {
    private Stack<Artikel> artikelen;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack<>(); 
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.push(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     * @return Het aantal artikelen 
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen 
     * op dienblad uit te rekenen
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        double totaal = 0;

        for(;this.getAantalArtikelen() > 0;) {
            Artikel artikel = artikelen.pop();
            totaal += artikel.getPrijs();
        }
        return totaal;
    }
}