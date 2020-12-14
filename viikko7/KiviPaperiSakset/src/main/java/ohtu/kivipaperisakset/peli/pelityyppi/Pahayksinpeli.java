package ohtu.kivipaperisakset.peli.pelityyppi;

import ohtu.kivipaperisakset.peli.pelaaja.Ihminen;
import ohtu.kivipaperisakset.peli.pelaaja.TekoalyParannettu;

public class Pahayksinpeli extends KiviPaperiJaSakset {
 
    public void pelaa() {
        Ihminen ihminen1 = new Ihminen("Pelaaja1");
        TekoalyParannettu tekoaly2 = new TekoalyParannettu(100);
        pelaa(ihminen1, tekoaly2);        
    }

}
