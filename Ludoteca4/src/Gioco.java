public class Gioco extends Prodotto {
    public int durataMediaPartita;

    public Gioco(String titolo, String autore, String casaEditrice, int annoPubblicazione, int durataMediaPartita) {
        super(titolo, autore, casaEditrice, annoPubblicazione);
        this.durataMediaPartita = durataMediaPartita;
    }

    public int getDurataMediaPartita() {
        return durataMediaPartita;
    }
}
