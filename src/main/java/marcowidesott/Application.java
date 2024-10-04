package marcowidesott;

import marcowidesott.files.Genere;
import marcowidesott.files.Gioco;
import marcowidesott.files.GiocoDaTavolo;
import marcowidesott.files.Videogioco;

import java.util.*;

public class Application {

    private static List<Gioco> giochi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        giochi.add(new Videogioco("Call Of Duty: Black Ops 6", 2024, 79.99, "PC", 120, Genere.FPS));
        giochi.add(new Videogioco("Fifa 25", 2024, 69.99, "PS5", 60, Genere.SPORT));
        giochi.add(new Videogioco("Assassin' s Creed", 2019, 49.99, "PS5", 80, Genere.AVVENTURA));
        giochi.add(new GiocoDaTavolo("Risiko", 1960, 28.99, 6, 240));
        giochi.add(new GiocoDaTavolo("Monopoly", 1945, 35.99, 4, 120));
        giochi.add(new GiocoDaTavolo("Taboo", 1970, 19.99, 8, 100));

        for (Gioco gioco : giochi) {
            gioco.descrizione();
        }

        while (true) {
            System.out.println("Scecgli un' opzione:");
            System.out.println("1: Aggiungi un gioco");
            System.out.println("2: Visualizza giochi");
            System.out.println("3: Cerca un gioco per id");
            System.out.println("4:Cerca un gioco per prezzo");
            System.out.println("5: cerca un gioco per numero di giocatori");
            System.out.println("6: rimuovi gioco");
            System.out.println("7: Aggiorna gioco");
            System.out.println("0: Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta == 1) {
                aggiungiGioco();
            } else if (scelta == 0) {
                break;
            } else if (scelta == 2) {
                visualizzaGiochi();
            } else if (scelta == 3) {
                cercaGiocoPerId();
            } else if (scelta == 4) {
                cercaGiocoPerPrezzo();
            } else if (scelta == 5) {
                cercaGiocoDaTavoloPerGiocatori();
            } else if (scelta == 6) {
                rimuoviGioco();
            } else if (scelta == 7) {
                aggiornaGioco();
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

    public static void cercaGiocoPerId() {
        System.out.println("Inserisci l' id del gioco da cercare: ");
        int idRicerca = scanner.nextInt();
        scanner.nextLine();

        Optional<Gioco> giocotrovato = giochi.stream()
                .filter(g -> g.getId() == idRicerca)
                .findFirst();
        if (giocotrovato.isPresent()) {
            System.out.println("Gioco trovato: ");
            giocotrovato.get().descrizione();
        } else {
            System.out.println("Nessun gioco trovato con id: " + idRicerca);
        }
    }

    public static void cercaGiocoPerPrezzo() {
        System.out.println("Inserisci il prezzo massimo: ");
        double prezzoMax = scanner.nextDouble();

        List<Gioco> giochiTrovati = giochi.stream()
                .filter(gioco -> gioco.getPrezzo() < prezzoMax)
                .toList();

        if (giochiTrovati.isEmpty()) {
            System.out.println("Nessun gioco trovato von prezzo inferiore a " + prezzoMax);
        } else {
            System.out.println("Giochi trovati von prezzo inferiore a " + prezzoMax + ": ");
            for (Gioco gioco : giochiTrovati) {
                gioco.descrizione();
            }
        }
    }

    private static void cercaGiocoDaTavoloPerGiocatori() {
        System.out.println("Inserisci il numero massimo di giocatori: ");
        int numGiocatoriMax = scanner.nextInt();

        List<Gioco> giochiTrovati = giochi.stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo && ((GiocoDaTavolo) gioco).getNumeroGiocatori() <= numGiocatoriMax)
                .toList();

        if (giochiTrovati.isEmpty()) {
            System.out.println("Nessun gioco da tavolo trovato con max " + numGiocatoriMax);
        } else {
            System.out.println("giochi da tavolo trovati con mac giocaotri " + numGiocatoriMax + ": ");
            for (Gioco gioco : giochiTrovati) {
                gioco.descrizione();
            }
        }
    }

    private static void rimuoviGioco() {
        System.out.println("Inserisci l' id del gioco da rimuovere: ");
        int idDaRimuovere = scanner.nextInt();

        boolean rimosso = giochi.removeIf(gioco -> gioco.getId() == idDaRimuovere);

        if (rimosso) {
            System.out.println("Gioco con id " + idDaRimuovere + "rimosso.");
        } else {
            System.out.println("Nessun gioco trovato con id " + idDaRimuovere);
        }
    }

    public static void aggiornaGioco() {
        try {


            System.out.println("Inserisci l' id del gioco da modificare: ");
            int idDaAggiornare = scanner.nextInt();

            Optional<Gioco> giocoOptional = giochi.stream()
                    .filter(gioco -> gioco.getId() == idDaAggiornare)
                    .findFirst();

            if (giocoOptional.isPresent()) {
                Gioco giocoDaAggiornare = giocoOptional.get();

                System.out.println("Inserisci il nuovo titolo (attuale: " + giocoDaAggiornare.getTitolo() + "): ");
                String nuovoTitolo = scanner.next();
                scanner.nextLine();
                System.out.print("Inserisci il nuovo anno di pubblicazione (attuale: " + giocoDaAggiornare.getAnnoPubblicazione() + "): ");
                int nuovoAnno = scanner.nextInt();
                System.out.print("Inserisci il nuovo prezzo (attuale: " + giocoDaAggiornare.getPrezzo() + "): ");
                double nuovoPrezzo = scanner.nextDouble();

                if (giocoDaAggiornare instanceof Videogioco) {
                    System.out.println("Inserisci la nuova piattaforma: ");
                    String nuovaPiattaforma = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Inserisci la nuova durata (in ore): ");
                    int nuovaDurata = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci il nuovo genere: ");
                    Genere nuovoGenere = Genere.valueOf(scanner.next().toUpperCase());
                    scanner.nextLine();

                    giocoDaAggiornare.setTitolo(nuovoTitolo);
                    giocoDaAggiornare.setAnnoPubblicazione(nuovoAnno);
                    giocoDaAggiornare.setPrezzo(nuovoPrezzo);
                    ((Videogioco) giocoDaAggiornare).setPiattaforma(nuovaPiattaforma);
                    ((Videogioco) giocoDaAggiornare).setDurata(nuovaDurata);
                    ((Videogioco) giocoDaAggiornare).setGenere(nuovoGenere);
                } else if (giocoDaAggiornare instanceof GiocoDaTavolo) {
                    System.out.println("Inserisci il nuovo numero di giocatori: ");
                    int nuovoNumeroGiocaotri = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Inserisci la nuova durata media: ");
                    int nuovaDurataMedia = scanner.nextInt();
                    scanner.nextLine();

                    giocoDaAggiornare.setTitolo(nuovoTitolo);
                    giocoDaAggiornare.setAnnoPubblicazione(nuovoAnno);
                    giocoDaAggiornare.setPrezzo(nuovoPrezzo);
                    ((GiocoDaTavolo) giocoDaAggiornare).setNumGiocatori(nuovoNumeroGiocaotri);
                    ((GiocoDaTavolo) giocoDaAggiornare).setDurataMedia(nuovaDurataMedia);

                }

                System.out.println("Gioco aggiornato con successo ");
            } else {
                System.out.println("Nessun gioco trovato con id fornito ");
            }
        } catch (InputMismatchException e) {
            System.out.println("Errore di input. Assicurati di inserire i dati nel formato corretto.");
            scanner.next();
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: Genere non valido. Assicurati di inserire un genere corretto.");
        } catch (Exception e) {
            System.out.println("Si è verificato un errore imprevisto: " + e.getMessage());
        }
    }
}
