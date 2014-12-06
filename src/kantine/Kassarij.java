package kantine;

import java.util.LinkedList;

/**
* Een klasse die lijst van personen bijhoud die in een rij staan.
* Dit word een onderdeel van een grotere applicatie.
* 
* @author David Bor
* @version 28-11-2014
*/

class Kassarij {
	private LinkedList<Persoon> personen;
	
	/**
	 * Constructor
	 */
	public Kassarij() 
	{
	  personen = new LinkedList<>(); 
	}
	
	/**
	 * Persoon sluit achter in de rij aan
	 * @param persoon
	 */
	public void sluitAchteraan(Persoon persoon) 
	{
		personen.add(persoon);
	}
	
	/**
	 * Indien er een rij bestaat, de eerste Persoon uit
	 * de rij verwijderen en retourneren. 
	 * Als er niemand in de rij staat geeft deze null terug.
	 * @return Eerste persoon in de rij of null
	 */
	public Persoon eerstePersoonInRij() 
	{
		boolean eenRij = erIsEenRij();
		Persoon persoon;
		if(eenRij) {
			persoon = personen.get(0);
			personen.remove(0);
			return persoon;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Methode kijkt of er personen in de rij staan. 
	 * @return Of er wel of geen rij bestaat
	 */
	public boolean erIsEenRij() 
	{
		boolean eenRij;
		if(personen.size() > 0) {
			eenRij = true;
		}
		else {
			eenRij = false;
		}
		return eenRij;
	}
}
