package ohtu.kivipaperisakset.peli.pelityyppi;

import ohtu.kivipaperisakset.peli.pelaaja.Tekoaly;
import ohtu.kivipaperisakset.peli.pelaaja.TekoalyParannettu;

public class TekoalyVastaanEdistynytTekoaly extends KiviPaperiJaSakset {
    
    public void pelaa() {
        Tekoaly tekoaly = new Tekoaly();
        TekoalyParannettu tekoaly2 = new TekoalyParannettu(100);
        pelaa(tekoaly, tekoaly2);        
    }
}
