package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

//     aloitetaan asiointi, koriin lisätään tuote, jota varastossa on ja suoritetaan ostos, 
// eli kutsutaan metodia kaupan tilimaksu(), varmista että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, 
// tilinumeroilla ja summalla
// tämä siis on muuten copypaste esimerkistä, mutta verify:ssä on tarkastettava että parametreilla on oikeat arvot
@Test
public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
    //verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    
    //public boolean tilimaksu(String nimi, String tiliNumero) {
    //int viite = viitegeneraattori.uusi();
    //int summa = ostoskori.hinta();
    //return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);

    // varmistetaan että kutsuttu oikeilla arvoilla
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(5));   

}

// aloitetaan asiointi, koriin lisätään kaksi eri tuotetta, joita varastossa on ja suoritetaan ostos, 
// varmista että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
@Test
public void kahdenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    // määritellään että tuote numero 2 on viina jonka hinta on 5 ja saldo 10
    when(varasto.saldo(2)).thenReturn(10); 
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "viina", 4));    

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(2);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");

    // varmistetaan että kutsuttu oikeilla arvoilla
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(4+5));   

}



// aloitetaan asiointi, koriin lisätään kaksi samaa tuotetta, jota on varastossa tarpeeksi 
// ja suoritetaan ostos, varmista että kutsutaan pankin metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
@Test
public void kahdenSamanTuotteenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");
    
    //public boolean tilimaksu(String nimi, String tiliNumero) {
    //int viite = viitegeneraattori.uusi();
    //int summa = ostoskori.hinta();
    //return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);

    // varmistetaan että kutsuttu oikeilla arvoilla
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(5+5));   

}


// aloitetaan asiointi, koriin lisätään tuote, jota on varastossa tarpeeksi 
// ja tuote joka on loppu ja suoritetaan ostos, varmista että kutsutaan pankin 
// metodia tilisiirto oikealla asiakkaalla, tilinumerolla ja summalla
@Test
public void tuotteenJaLoppuneenTuotteenOstoksienPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaArvoilla() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
    // määritellään että tuote numero 2 on järki jonka hinta on 1 ja saldo 0
    when(varasto.saldo(2)).thenReturn(0); 
    when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "järki", 1));


    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.lisaaKoriin(2);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");
    
    //public boolean tilimaksu(String nimi, String tiliNumero) {
    //int viite = viitegeneraattori.uusi();
    //int summa = ostoskori.hinta();
    //return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);

    // varmistetaan että kutsuttu oikeilla arvoilla
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(5));   

}

// aloitaAsiointi kutsuminen nollaa edellisen ostoksen tiedot 
@Test
public void aloitaAsiointiKutsuminenNollaaEdellisenOstoksenTiedot () {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);
    // määritellään että viitegeneraattori palauttaa viitten 42
    when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(5));   

    k.aloitaAsiointi();
    k.tilimaksu("pekka", "12345");
    verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(),eq(0));   

}

// varmista, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle
@Test
public void varmistaEttaKauppaPyytaaUudenViitenumeronJokaiselleMaksutapahtumalle() {
    // luodaan ensin mock-oliot
    Pankki pankki = mock(Pankki.class);

    Viitegeneraattori viite = mock(Viitegeneraattori.class);

    when(viite.uusi())
    .thenReturn(1)
    .thenReturn(2)
    .thenReturn(3);    

    // määritellään että viitegeneraattori palauttaa viitten 42
    // when(viite.uusi()).thenReturn(42);

    Varasto varasto = mock(Varasto.class);
    // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
    when(varasto.saldo(1)).thenReturn(10); 
    when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

    // sitten testattava kauppa 
    Kauppa k = new Kauppa(varasto, pankki, viite);              

    // tehdään ostokset
    k.aloitaAsiointi();
    k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
    k.tilimaksu("pekka", "12345");
    verify(pankki).tilisiirto(eq("pekka"), eq(1), eq("12345"), anyString(),eq(5));   

    k.aloitaAsiointi();
    k.tilimaksu("pekka", "12345");
    verify(pankki).tilisiirto(eq("pekka"), eq(2), eq("12345"), anyString(),eq(0));   

    k.aloitaAsiointi();
    k.tilimaksu("pekka", "12345");
    verify(pankki).tilisiirto(eq("pekka"), eq(3), eq("12345"), anyString(),eq(0));   

}

@Test
    public void varastoTestii() {
        // luodaan ensin mock-oliot
        Pankki pankki = mock(Pankki.class);

        Viitegeneraattori viite = mock(Viitegeneraattori.class);
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        Varasto varasto = mock(Varasto.class);
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // testcoveragee..
        // varasto.haeTuote(1);
        // verify(varasto).haeTuote(eq(1));
        // varasto.saldo(1);
        // verify(varasto).saldo(eq(1));
        // Tuote x = new Tuote(1, "maito", 5);
        // varasto.otaVarastosta(x);
        // verify(varasto).otaVarastosta(x);

        // varasto.palautaVarastoon(x);
        // verify(varasto).palautaVarastoon(x);

        // sitten testattava kauppa 
        Kauppa k = new Kauppa(varasto, pankki, viite);              

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.poistaKorista(1); // TEST COVER..
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }



}