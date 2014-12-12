public class Administratie {
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
    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp=new double[7];
        
        for(int i=0;i<7;i++) {
        int j=0;
            while(...) {
                temp[i]+=omzet[i+7*j];
                //omitted
        }
    }
    return temp;
    }
}