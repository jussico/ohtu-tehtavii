package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Plus extends Komento {

    public Plus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void toiminto() {
        
        sovellus.plus(arvo);

    }

    @Override
    public void peruutusToiminto() {
        sovellus.miinus(arvo);
    }
    
}
