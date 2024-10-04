package marcowidesott.files;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durata;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durata, Genere genere) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public void descrizione() {
        System.out.println("Videogioco: ID " + getId() + ", Titolo: " + getTitolo() +
                ", Anno: " + getAnnoPubblicazione() + ", Prezzo: €" + getPrezzo() +
                ", Piattaforma: " + piattaforma + ", Durata: " + durata + " ore" +
                ", Genere: " + genere);
    }

}
