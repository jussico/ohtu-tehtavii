package ohtu.kivipaperisakset;

import java.util.Scanner;

import ohtu.kivipaperisakset.peli.pelityyppi.Kaksinpeli;
import ohtu.kivipaperisakset.peli.pelityyppi.KiviPaperiJaSakset;
import ohtu.kivipaperisakset.peli.pelityyppi.Pahayksinpeli;
import ohtu.kivipaperisakset.peli.pelityyppi.TekoalyVastaanEdistynytTekoaly;
import ohtu.kivipaperisakset.peli.pelityyppi.Yksinpeli;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\n (d) tekoäly vs parannettu tekoäly"                    
                    + "\nmuilla valinnoilla lopetataan");

            KiviPaperiJaSakset peli;
            String vastaus = scanner.nextLine();
            if (vastaus.endsWith("a")) {
                 peli = KiviPaperiJaSakset.getGameType(Kaksinpeli.class);
            } else if (vastaus.endsWith("b")) {
                peli = KiviPaperiJaSakset.getGameType(Yksinpeli.class);
            } else if (vastaus.endsWith("c")) {
                peli = KiviPaperiJaSakset.getGameType(Pahayksinpeli.class);
            } else if (vastaus.endsWith("d")) {
                peli = KiviPaperiJaSakset.getGameType(TekoalyVastaanEdistynytTekoaly.class);
            } else {
                break;
            }
            peli.pelaa();
        }
    }
}
