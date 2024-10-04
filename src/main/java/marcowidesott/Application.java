package marcowidesott;

import marcowidesott.files.Genere;
import marcowidesott.files.Gioco;
import marcowidesott.files.GiocoDaTavolo;
import marcowidesott.files.Videogioco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static List<Gioco> giochi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        giochi.add(new Videogioco("Call Of Duty: Black Ops 6", 2024, 79.99, "PC", 120, Genere.FPS));
        giochi.add(new Videogioco("Fifa 25", 2024, 69.99, "PS5", 60, Genere.SPORT));
        giochi.add(new GiocoDaTavolo("Risiko", 1960, 28.99, 6, 240));
        giochi.add(new GiocoDaTavolo("Monopoly", 1945, 35.99, 4, 120));

        for (Gioco gioco : giochi) {
            gioco.descrizione();
        }

        while (true) {
            System.out.println("Scecgli un' opzione:");
            System.out.println("1: Aggiungi un gioco");
            System.out.println("2: Visualizza giochi");
            System.out.println("0: Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta == 1) {
                aggiungiGioco();
            } else if (scelta == 0) {
                break;
            } else if (scelta == 2) {
                visualizzaGiochi();
            } else {
                System.out.println("Opazione non valida.");
            }
        }


    }

    private static void aggiungiGioco() {
        System.out.print("Scegli il tipo di gioco da aggiungere (1: Videogioco, 2: Gioco da Tavolo): ");
        int tipoGioco = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserisci il titolo del gioco: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci l'anno di pubblicazione: ");
        int annoPubblicazione = scanner.nextInt();

        double prezzo = 0;
        boolean prezzoValido = false;

        while (!prezzoValido) {
            try {
                System.out.print("Inserisci il prezzo: ");
                prezzo = scanner.nextDouble();
                prezzoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Prezzo non valido. Inserisci un numero valido (es. 89.99).");
                scanner.next();
            }
        }

        System.out.print("Inserisci l'ID del gioco: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exists = giochi.stream().anyMatch(g -> g.getId() == id);
        if (exists) {
            System.out.println("Errore: Esiste già un gioco con ID " + id);
            return;
        }

        if (tipoGioco == 1) {
            System.out.println("Inserisci la piattaforma: ");
            String piattaforma = scanner.nextLine();


            System.out.println("inserisci la durata del gioco (in ore): ");
            int durata = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci il genere (RPG, FPS, STRATEGIA, AVVENTURA, PUZZLE, SPORT): ");
            String genereInput = scanner.nextLine();
            Genere genere = Genere.valueOf(genereInput.toUpperCase());

            giochi.add(new Videogioco(titolo, annoPubblicazione, prezzo, piattaforma, durata, genere));
            System.out.println("Videogioco aggiunto con successo");
        } else if (tipoGioco == 2) {
            System.out.println("Inserisci il numero di giocatori (da 2 a 10): ");
            int numeroGiocatori = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci la durata della partita (in minuti): ");
            int durataMediaPartita = scanner.nextInt();
            scanner.nextLine();

            giochi.add(new GiocoDaTavolo(titolo, annoPubblicazione, prezzo, numeroGiocatori, durataMediaPartita));
            System.out.println("Gioco da tavolo aggiunto!");
        } else {
            System.out.println("Tipo di gioco non valido");
        }


    }

    public static void visualizzaGiochi() {
        if (giochi.isEmpty()) {
            System.out.println("Nessun gioco nella collection");
        } else {
            System.out.println("Giochi nella collection: ");
            for (Gioco gioco : giochi) {
                gioco.descrizione();
            }
        }
    }
}
