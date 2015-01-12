package kantine;

import java.util.*;


/**
 * Een klasse die aan de hand van andere klassen
 * simuleert hoe de verkoop gaat in een kantine.
 * 
 * @author David Bor & Ronald Scholten 
 * @version 11-01-2015
 */
public class KantineSimulatie 
{
    // kantine
    private Kantine kantine;
    
    // kantineaanbod
    private KantineAanbod kantineaanbod;
    
    // random generator
    private Random random;
    
    // Scanner
    Scanner reader;
    
    // aantal artikelen
    private int aantalArtikelen;
    
    // hoeveelheden van artikelen
    private int[] hoeveelheden; 
    
    // artikelnamen
    ArrayList<String> artikelnamen;
    
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
        reader = new Scanner(System.in);
        kantineaanbod = composeKantineAanbod();
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
            artikelen[i] = artikelnamen.get(indexen[i]);
        }
        return artikelen;
    }
    
    private KantineAanbod composeKantineAanbod()
    {
        artikelnamen = new ArrayList<>();
        ArrayList<Double> artikelprijzen = new ArrayList<>();
        String inputLine;
        
        boolean finished = false;
        System.out.println("Voeg de artikelen toe die in het assortiment van uw kantine wilt hebben.");
        System.out.println("Doe dit door (artikelnaam)*spatie*(artikelprijs (met ',decimalen'!)) in te voeren.");
        System.out.println("Als u klaar bent typed u 'klaar' om verder te gaan.");
        while(!finished) {
            String artikelnaam = "";
            
            System.out.println("Voer een artikel in:");
            System.out.print("> ");
            inputLine = reader.nextLine();
            
            Scanner tokenizer = new Scanner(inputLine);
            while(tokenizer.hasNext() && (!tokenizer.hasNextDouble() || tokenizer.hasNextInt())) {
                artikelnaam += tokenizer.next() + " ";
            }
            if(artikelnaam.equals("klaar ")) {
                finished = true;
            }
            else if(tokenizer.hasNextDouble()) {
                artikelnamen.add(artikelnaam);
                artikelprijzen.add(tokenizer.nextDouble());
            }
            else {
                System.out.println("Vul a.u.b. volgens het format (artikelnaam)*spatie*(artikelprijs met decimalen!) in.");
            }
        }
        
        aantalArtikelen = artikelnamen.size();
        String[] artikelNamen = new String[aantalArtikelen];
        double[] artikelPrijzen = new double[aantalArtikelen];
        
        for(int i = 0; i < aantalArtikelen; i++) {
            artikelNamen[i] = artikelnamen.get(i);
            artikelPrijzen[i] = artikelprijzen.get(i);
        }
        
        hoeveelheden = getRandomArray(aantalArtikelen, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        return new KantineAanbod(artikelNamen, artikelPrijzen, hoeveelheden);
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
                
                int betaaltype = getRandomValue(0, 1);
                Betaalwijze betaalwijze;
                if(betaaltype == 0) {
                    int intSaldo = getRandomValue(500, 2500);
                    double saldo = intSaldo / 100.0;
                    betaalwijze = new Contant(saldo);
                }
                else if(betaaltype == 1) {
                    int intSaldo = getRandomValue(500, 21054);
                    double saldo = intSaldo / 100.0;
                    int intKredLimiet = getRandomValue(-10000, 0);
                    double kredLimiet = intKredLimiet / 100.0;
                    betaalwijze = new Pinpas(saldo, kredLimiet);
                }
                else {
                    betaalwijze = null;
                }
                persoon.setBetaalwijze(betaalwijze);
                
                Dienblad dienblad = new Dienblad();
                persoon.pakDienblad(dienblad);
        
                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);
                int[] tepakken = getRandomArray(aantalartikelen, 0, aantalArtikelen-1);
                String[] artikelen = geefArtikelNamen(tepakken);
                
                persoon.drukAf();
                kantine.loopPakSluitAan(persoon, artikelen);
                kantineaanbod.voorraadBijhouden(aantalArtikelen);
                
                try {
                    kantine.verwerkRijVoorKassa();
                }
                catch (TeWeinigGeldException e){
                    System.out.println(e.getS());
                    System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " heeft niet voldoende saldo");
                }
            }
            
            dagGepasseerdeArtikelen[i] = kantine.getKassa().aantalArtikelen();
            dagOmzetten[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            
            System.out.println("De dag totalen van dag " + (i + 1) + ":");
            System.out.println("Aantal artikelen: "+ dagGepasseerdeArtikelen[i] +"");
            System.out.println("Hoeveelheid geld van kassa: "+ dagOmzetten[i] +"");
            System.out.println("Aantal klanten: " + aantalpersonen + "");
            System.out.println();
            
            kantine.getKassa().resetKassa();
            
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
