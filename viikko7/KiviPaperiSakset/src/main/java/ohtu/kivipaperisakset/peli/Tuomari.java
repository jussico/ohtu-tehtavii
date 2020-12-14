package ohtu.kivipaperisakset.peli;

// Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.
public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;
    private long maxSiirrot;

    public Tuomari(long maxSiirrot) {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
        this.maxSiirrot = maxSiirrot;
    }

    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        } else {
            tokanPisteet++;
        }
    }

    public boolean pelitPelattu() {
        return (ekanPisteet + tokanPisteet + tasapelit) > maxSiirrot;
    }

    // sisäinen metodi, jolla tarkastetaan tuliko tasapeli
    private static boolean tasapeli(String eka, String toka) {
        if (eka.equals(toka)) {
            return true;
        }

        return false;
    }

    // sisäinen metodi joka tarkastaa voittaako eka pelaaja tokan
    private static boolean ekaVoittaa(String eka, String toka) {
        if ("k".equals(eka) && "s".equals(toka)) {
            return true;
        } else if ("s".equals(eka) && "p".equals(toka)) {
            return true;
        } else if ("p".equals(eka) && "k".equals(toka)) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet + "\n"
                + "Tasapelit: " + tasapelit;
        return s;
    }
}