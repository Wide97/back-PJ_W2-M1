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

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public void descrizione() {
        System.out.println("Videogioco: ID " + getId() + ", Titolo: " + getTitolo() +
                ", Anno: " + getAnnoPubblicazione() + ", Prezzo: €" + getPrezzo() +
                ", Piattaforma: " + piattaforma + ", Durata: " + durata + " ore" +
                ", Genere: " + genere);
    }

}
