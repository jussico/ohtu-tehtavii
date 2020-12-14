package ohtu.kivipaperisakset.peli.pelaaja;

import java.util.Scanner;

public class Ihminen extends Pelaaja {

    private static final Scanner scanner = new Scanner(System.in);

    private String nimi;

    public Ihminen(String nimi) {
        this.nimi = nimi;
    }

    public String annaSiirto() {
        System.out.print(nimi +" siirto: ");
        String siirto = scanner.nextLine();
        return siirto;
    }

    public void asetaSiirto(String siirto) {
        // ei tehdä mitään 
    }    

}