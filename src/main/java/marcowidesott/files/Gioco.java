package marcowidesott.files;

public abstract class Gioco {
    private static int idCounter = 1;
    private int id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(int id, String titolo, int annoPubblicazione, double prezzo) {
        this.id = idCounter++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        setPrezzo(prezzo);
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo > 0) {
            this.prezzo = prezzo;
        } else {
            throw new IllegalArgumentException("Il prezzo deve avere un valore maggiore di 0");
        }
    }

    public abstract void descrizione();

}
