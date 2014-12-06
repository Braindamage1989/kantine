package kantine;

import java.util.*;

/**
* Een klasse die aan de hand van andere klassen
* simuleert hoe de verkoop gaat in een kantine.
* 
* @author Ronald Scholten and David Bor
* @version 05-12-2014
*/
public class KantineSimulatie 
{
    // kantine
    private Kantine kantine;
    
    // kantineaanbod
    private KantineAanbod kantineaanbod;
    
    // random generator
    private Random random;
    
    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;
    
    // artikelen
    private static final String[] artikelnamen =
        new String[] {"Koffie","Broodje hamburger", "Broodje kaas", "Melk"};
    
    //hoeveelheden van artikelen
    private int[] hoeveelheden;
    
    // prijzen
    private static double[] artikelprijzen =
        new double[]{1.50, 2.10, 1.65, 1.65};   
    
    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;
    
    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;
    
    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    
    /**
     * Constructor
     */
    public KantineSimulatie()
    {
        kantine = new Kantine();
        random = new Random();
        hoeveelheden = getRandomArray(
            AANTAL_ARTIKELEN,MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, 
            hoeveelheden); 
        kantine.setKantineAanbod(kantineaanbod);
    }
    
    /**
     * Methode om een array van random getallen liggend tussen min en max 
     * van de gegeven lengte te genereren
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) 
    {
        int[] temp = new int[lengte];
        for(int i = 0;i < lengte;i++) {
            temp[i] = getRandomValue(min, max);
        }
        return temp;
    }
    
    /**
     * Methode om een random getal tussen min(incl) en 
     * max(incl) te genereren.
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) 
    {
        return random.nextInt(max-min+1)+min;
    }
    
    /**
     * Methode om op basis van een array van indexen voor de array 
     * artikelnamen de bijhorende array van artikelnamen te maken
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) 
    {
        String[] artikelen = new String[indexen.length];
        for(int i = 0;i < indexen.length;i++) { 
            artikelen[i] = artikelnamen[indexen[i]];
        }
        return artikelen;
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
    
    /**
     * Methode om de voorraad van de kantine bij te houden
     */
    private void voorraadBijhouden() 
    {
        for (int i = 0; i < AANTAL_ARTIKELEN; i++) {
            ArrayList<Artikel> artikel = kantineaanbod.getArrayList(artikelnamen[i]);
            if (checkVoorraad(artikel, i)) {
                vulVoorraadBij(artikel, i);
            }
        }
    }
    
    /**
     * Deze methode simuleert een aantal dagen in het 
     * verloop van de kantine
     * @param dagen
     */
    public void simuleer(int dagen) 
    {
        // for lus voor dagen
        for(int i = 0;i < dagen;i++) {
            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // laat de personen maar komen...
            for(int j = 0;j < aantalpersonen;j++) {
                // maak persoon en dienblad aan, koppel ze
                Persoon persoon = new Persoon();
                Dienblad dienblad = new Dienblad();
                persoon.pakDienblad(dienblad);
        
                // bedenk hoeveel artikelen worden gepakt
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                
                // genereer de "artikelnummers", dit zijn indexen 
                // van de artikelnamen array  
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
                
                // vind de artikelnamen op basis van 
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste 
                // artikelen, sluit aan
                kantine.loopPakSluitAan(persoon, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            
            // druk de dagtotalen af en hoeveel personen binnen 
            // zijn gekomen
            Kassa kassa = kantine.getKassa();
            String totalPassed = "Aantal artikelen: "+ kassa.aantalArtikelen() +"";
            String totalIncome = "Hoeveelheid geld van kassa: "+ kassa.hoeveelheidGeldInKassa() +"";
            
            System.out.println("De dag totalen van dag " + (i + 1) + ":");
            System.out.println(totalPassed);
            System.out.println(totalIncome);
            System.out.println("Aantal klanten: " + aantalpersonen + "");
            System.out.println();
            
            // reset de kassa voor de volgende dag
            kassa.resetKassa();
            
            //Voorraadchecken en bijvullen wanneer nodig
            voorraadBijhouden();
        }
    }
}
