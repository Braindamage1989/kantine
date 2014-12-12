package kantine;

/**
 * Klasse om de administratie bij te houden...
 * 
 * @author David Bor and Ronald Scholten
 * @version 12-12-2014
 */
public class Administratie {
	private static final int DAYS_IN_WEEK = 7;
	
    /**
    * Deze methode berekent van de int array aantal de 
    * gemiddelde waarde
    * @param aantal
    * @return het gemiddelde
    */
    private Administratie() {};
    
    public static double berekenGemiddeldAantal(int[] aantal) {
        double totaal = 0;
        int deler = 0;
        double gemiddeldAantal;
        if(aantal.length>0) {
            for(double aantallen : aantal) {
                totaal += aantallen;
                deler++;
            }
            gemiddeldAantal = totaal / deler;
        }
        else{
            gemiddeldAantal = 0;
        }   
        return gemiddeldAantal;
    }

    /**
    * Deze methode berekent van de double array omzet de 
    * gemiddelde waarde
    * @param omzet
    * @return Het gemiddelde
    */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double totaal = 0;
        int deler = 0;
        double gemiddeldeOmzet;
        if(omzet.length>0) {
            for(double dagomzet : omzet) {
                totaal += dagomzet;
                deler++;
            }
            gemiddeldeOmzet = totaal / deler;
        }
        else{
            gemiddeldeOmzet = 0;
        }
        return gemiddeldeOmzet;
    }
    
    /**
     * Methode om dagomzet uit te rekenen
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */
    public static double[] berekenDagOmzet(double[] omzet)
    {
    	double[] temp = new double[DAYS_IN_WEEK];
    	for(int i = 0; i < DAYS_IN_WEEK; i++){
    		int j = 0;
    		while((i + DAYS_IN_WEEK*j) < omzet.length) {
    		    
    			temp[i] += omzet[i + DAYS_IN_WEEK*j];
    			j++;
    		}
    	}
    	return temp;
    }
}