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
        int[] dagGepasseerdeArtikelen = new int[dagen];
        double[] dagOmzetten = new double[dagen];
        
        for(int i = 0;i < dagen;i++) {
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            for(int j = 0;j < aantalpersonen;j++) {
                Persoon persoon;
                int type = getRandomValue(0, 99);
                if(type < 89) {
                    persoon = new Student(13542856, "Paula", "Berksen", 1978, 4, 12, 'v', "321514", "ICT");
                }
                else if(type >= 89 && type < 99) {
                    persoon = new Docent(36254125, "Henk", "Rodens", 1986, 8, 25, 'm', "ROHE", "ICT");
                }
                else {
                    persoon = new KantineMedewerker(52145215, "Rosa", "Noda", 1995, 11, 2, 'v', "1254", false);
                }
                
                Dienblad dienblad = new Dienblad();
                persoon.pakDienblad(dienblad);
        
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);
                String[] artikelen = geefArtikelNamen(tepakken);
                
                persoon.drukAf();
                kantine.loopPakSluitAan(persoon, artikelen);
            }

            kantine.verwerkRijVoorKassa();
            
            dagGepasseerdeArtikelen[i] = kantine.getKassa().aantalArtikelen();
            dagOmzetten[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            
            System.out.println("De dag totalen van dag " + (i + 1) + ":");
            System.out.println("Aantal artikelen: "+ dagGepasseerdeArtikelen[i] +"");
            System.out.println("Hoeveelheid geld van kassa: "+ dagOmzetten[i] +"");
            System.out.println("Aantal klanten: " + aantalpersonen + "");
            System.out.println();
            
            kantine.getKassa().resetKassa();
            
            voorraadBijhouden();
        }
        
        double[] dagOmzet = Administratie.berekenDagOmzet(dagOmzetten);
        
        System.out.println("Gemiddelden over de simulatie van " + dagen + " dagen:");
        System.out.println("Gemiddeld aantal artikelen: " + Administratie.berekenGemiddeldAantal(dagGepasseerdeArtikelen));
        System.out.println("Gemiddelde omzet: " + Administratie.berekenGemiddeldeOmzet(dagOmzetten));
        System.out.println("De omzet per weekdag:");
        System.out.println("   Maandag:   €" + dagOmzet[0]);
        System.out.println("   Disndag:   €" + dagOmzet[1]);
        System.out.println("   Woensdag:  €" + dagOmzet[2]);
        System.out.println("   Donderdag: €" + dagOmzet[3]);
        System.out.println("   Vrijdag:   €" + dagOmzet[4]);
        System.out.println("   Zaterdag:  €" + dagOmzet[5]);
        System.out.println("   Zondag:    €" + dagOmzet[6]);
        System.out.println();
    }
}
