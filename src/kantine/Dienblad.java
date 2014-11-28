import java.util.ArrayList;

public class Dienblad {
  private ArrayList<Artikel> artikelen;

  /**
   * Constructor
   */
  public Dienblad() {
    artikelen = new ArrayList<>(); 
  }

  /**
   * Methode om artikel aan dienblad toe te voegen
   * @param artikel
   */
  public void voegToe(Artikel artikel) {
      artikelen.add(artikel);
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
  public void getTotaalPrijs() {
      int totaal = 0;
      
      for(Artikel artikel : artikelen) {
          totaal += artikel.getPrijs();
      }
      System.out.println(totaal);
  }
}