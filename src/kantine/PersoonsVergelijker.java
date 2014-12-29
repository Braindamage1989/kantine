package kantine;

// kijk hier eens: http://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html

/**
 * Maak 2 personen aan, en vergelijk deze
 * @author Ronald Scholten
 * @version 27-12-2014
 */
public class PersoonsVergelijker
{
    public static void main(String[] args)
    {
        Persoon persoon1 = new Persoon(335003, "Ronald", "Scholten", 1989, 12, 25, 'm');
        Persoon persoon2 = new Persoon(335003, "Ronald", "Scholten", 1989, 12, 25, 'm');
        
        System.out.println(persoon1 == persoon2);
        System.out.println(persoon1.equals(persoon2));
    }
}
