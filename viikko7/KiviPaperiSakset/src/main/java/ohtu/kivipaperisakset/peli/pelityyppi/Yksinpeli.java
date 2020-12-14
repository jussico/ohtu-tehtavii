package ohtu.kivipaperisakset.peli.pelityyppi;

import ohtu.kivipaperisakset.peli.pelaaja.Ihminen;
import ohtu.kivipaperisakset.peli.pelaaja.Tekoaly;

public class Yksinpeli extends KiviPaperiJaSakset {
    
    public void pelaa() {
        Ihminen ihminen1 = new Ihminen("Pelaaja1");
        Tekoaly tekoaly = new Tekoaly();
        pelaa(ihminen1, tekoaly);        
    }

}
