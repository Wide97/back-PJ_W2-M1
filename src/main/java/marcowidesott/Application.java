package marcowidesott;

import marcowidesott.files.Genere;
import marcowidesott.files.Gioco;
import marcowidesott.files.GiocoDaTavolo;
import marcowidesott.files.Videogioco;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Gioco> giochi = new ArrayList<>();

        giochi.add(new Videogioco("Call Of Duty: Black Ops 6", 2024, 79.99, "PC", 120, Genere.FPS));
        giochi.add(new Videogioco("Fifa 25", 2024, 69.99, "PS5", 60, Genere.SPORT));
        giochi.add(new GiocoDaTavolo("Risiko", 1960, 28.99, 6, 240));
        giochi.add(new GiocoDaTavolo("Monopoly", 1945, 35.99, 4, 120));

        for (Gioco gioco : giochi) {
            gioco.descrizione();
        }

    }
}
