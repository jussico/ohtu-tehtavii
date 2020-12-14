package ohtu.kivipaperisakset.peli.pelityyppi;

import ohtu.kivipaperisakset.peli.Tuomari;
import ohtu.kivipaperisakset.peli.pelaaja.Pelaaja;

public abstract class KiviPaperiJaSakset {
    
    public abstract void pelaa();

    public void pelaa(Pelaaja pelaaja1, Pelaaja pelaaja2) {

        long raja = 1000;

        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        System.out.println("tai kun " + raja + " kierrosta pelattu.");

        Tuomari tuomari = new Tuomari(raja);

        String p1siirto;
        String p2siirto;        
        Boolean legal;
        do {
            p1siirto = pelaaja1.annaSiirto();
            p2siirto = pelaaja2.annaSiirto();
            legal = tuomari.onkoOkSiirto(p1siirto) && tuomari.onkoOkSiirto(p2siirto);
            if(legal) {
                tuomari.kirjaaSiirto(p1siirto, p2siirto);
            }
        } while (legal && !tuomari.pelitPelattu());

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }    

    public static KiviPaperiJaSakset getGameType(Class<? extends KiviPaperiJaSakset> pelityyppi) {
        KiviPaperiJaSakset returnValue;
        if(pelityyppi == Kaksinpeli.class) {
            returnValue = new Kaksinpeli();
        } else if(pelityyppi == Yksinpeli.class) {
            returnValue = new Yksinpeli();
        } else if(pelityyppi == Pahayksinpeli.class) {
            returnValue = new Pahayksinpeli();
        } else if(pelityyppi == TekoalyVastaanEdistynytTekoaly.class) {
            returnValue = new TekoalyVastaanEdistynytTekoaly();
        } else {
            throw new RuntimeException("tuntematon tyyppi : " + pelityyppi);
        }
        return returnValue;
    }
}
