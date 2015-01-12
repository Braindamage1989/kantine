package kantine;

import java.util.*;

/**
* Een klasse die het aanbod van een kantine
* bijhoud.
* 
* @author Ronald Scholten and David Bor
* @version 05-12-2014
*/
public class KantineAanbod 
{
    // interne opslag voorraad
    private HashMap<String, ArrayList<Artikel>> aanbod;
    String[] artikelnamen;
    double[] artikelprijzen;
    int[] hoeveelheden;
    
   
    
    /**
     * Constructor. Het eerste argument is een lijst met artikelnamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, double[] prijs, int[] hoeveelheid) 
    {
        this.artikelnamen = artikelnaam;
        this.artikelprijzen = prijs;
        this.hoeveelheden = hoeveelheid;
        aanbod = new HashMap<String, ArrayList<Artikel>>();
        for(int i = 0;i < artikelnaam.length;i++) {
            ArrayList<Artikel> artikelen = new ArrayList<Artikel>();
            for(int j = 0;j < hoeveelheid[i];j++) {
                artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
            }
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     * @param productnaam
     * @return een array met productgegevens
     */
    private ArrayList<Artikel> getArrayList(String productnaam) 
    {
         return aanbod.get(productnaam); 
    }

    /**
     * Private methode om een Artikel van de stapel artikelen af te pakken. 
     * Retourneert null als de stapel leeg is.
     * @param een array met productgegevens
     * @return null of een Artikel
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) 
    {
        if (stapel == null) { 
            return null;
        }
        if (stapel.size() == 0) {
           return null;
        }
        else {
            Artikel a = stapel.get(0);
            stapel.remove(0);
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param naam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String naam) 
    {
        return getArtikel(getArrayList(naam));
    }
    
    /**
     * Methode om de voorraad van de kantine bij te houden
     */
    public void voorraadBijhouden(int aantalArtikelen) 
    {
        for (int i = 0; i < aantalArtikelen; i++) {
            ArrayList<Artikel> artikel = getArrayList(artikelnamen[i]);
            if (checkVoorraad(artikel, i)) {
                vulVoorraadBij(artikel, i);
            }
        }
    }
    
    /**
     * Methode om te checken of een product nog voldoende op
     * voorraad is
     * @param artikelvoorraad
     * @param hoeveelste artikel het is
     * @return true of false
     */
    private boolean checkVoorraad(ArrayList<Artikel> artikel, int positie) 
    {
        if (artikel.size() < (hoeveelheden[positie] / 20)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Methode om de voorraad van de kantine bij te vullen
     * @param artikelvoorraad
     * @param hoeveelste artikel het is
     */
    private void vulVoorraadBij(ArrayList<Artikel> artikel, int positie) 
    {
        for (int i = artikel.size(); i <= hoeveelheden[positie]; i++) {
            artikel.add(new Artikel(artikelnamen[positie], artikelprijzen[positie]));
        }
    }
}
