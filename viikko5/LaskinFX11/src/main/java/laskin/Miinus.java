package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Miinus extends Komento {
 
    public Miinus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void toiminto() {
        
        sovellus.miinus(arvo);

    }    

    @Override
    public void peruutusToiminto() {
        sovellus.plus(arvo);
    }

}
