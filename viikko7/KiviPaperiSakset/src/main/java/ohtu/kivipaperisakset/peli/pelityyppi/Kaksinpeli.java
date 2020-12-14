package ohtu.kivipaperisakset.peli.pelityyppi;

import ohtu.kivipaperisakset.peli.pelaaja.Ihminen;

public class Kaksinpeli extends KiviPaperiJaSakset {
 
    public void pelaa() {
        Ihminen ihminen1 = new Ihminen("Pelaaja1");
        Ihminen ihminen2 = new Ihminen("Pelaaja2");
        pelaa(ihminen1, ihminen2);        
    }

}
