package marcowidesott.files;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMedia;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int durataMedia) {
        super(titolo, annoPubblicazione, prezzo);
        if (numeroGiocatori >= 2 && numeroGiocatori <= 10) {
            this.numeroGiocatori = numeroGiocatori;
        } else {
            throw new IllegalArgumentException("I giocatori devono essere tra i 2 e i 10");
        }
        this.durataMedia = durataMedia;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) {
        this.numeroGiocatori = numGiocatori;
    }

    public int getDurataMedia() {
        return durataMedia;
    }

    public void setDurataMedia(int durataMedia) {
        this.durataMedia = durataMedia;
    }

    @Override
    public void descrizione() {
        System.out.println("Gioco da Tavolo: ID " + getId() + ", Titolo: " + getTitolo() +
                ", Anno: " + getAnnoPubblicazione() + ", Prezzo: €" + getPrezzo() +
                ", Numero Giocatori: " + numeroGiocatori + ", Durata Media: " + durataMedia + " minuti");
    }


}
