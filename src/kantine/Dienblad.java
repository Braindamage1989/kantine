package kantine;

import java.util.Stack;
import java.util.Iterator;

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

    public Iterator<Artikel> getArtikelen()
    {
        return artikelen.iterator();
    }
}