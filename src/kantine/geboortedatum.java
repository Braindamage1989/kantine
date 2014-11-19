/**
 * Getter voor geboortedatum
 * @return Geboortedatum 
 */
public String getGeboorteDatum() {
  String temp;
  if (dag==0 && maand==0 && jaar==0) {
    temp="Onbekend";
  } else {
    temp=dag+"/"+maand+"/"+jaar;
  }
  return temp;
}
