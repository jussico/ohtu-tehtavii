package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected TextField tuloskentta;
    protected TextField syotekentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovellus;

    protected int arvo;
    protected int tulos;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
        
    }

    public void suorita() {
        parsiArvo();
        toiminto();
        tulos = sovellus.tulos();                
        updateUI();
    };

    protected void updateUI() {
        syotekentta.setText("");
        tuloskentta.setText("" + tulos);
        if ( tulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);                
    }

    public abstract void toiminto();
    public abstract void peruutusToiminto();

    public void peru() {
        peruutusToiminto();
        tulos = sovellus.tulos();
        updateUI();
    }

    private void parsiArvo() { 
        try {
        this.arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception x) {
            System.out.println("mitävittuu");
            // nice
        }
    }

//     komento.suorita();
//     this.edellinen = komento;
// } else {
//     this.edellinen.peru();

    // public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
    //     this.undo = undo;
    //     this.sovellus = new Sovelluslogiikka();
    //     this.komennot = new HashMap<>();
    //     this.komennot.put(plus, new Summa(tuloskentta, syotekentta,  nollaa, undo, sovellus) );



}
