import java.util.Objects;

public abstract class Prodotto {
    public String titolo;
    public String autore;
    public String casaEditrice;
    public int annoPubblicazione;

    public Prodotto(String titolo, String autore, String casaEditrice, int annoPubblicazione) {
        this.titolo = titolo;
        this.autore = autore;
        this.casaEditrice = casaEditrice;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return annoPubblicazione == prodotto.annoPubblicazione && Objects.equals(titolo, prodotto.titolo) && Objects.equals(autore, prodotto.autore) && Objects.equals(casaEditrice, prodotto.casaEditrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore, casaEditrice, annoPubblicazione);
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", casaEditrice='" + casaEditrice + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                '}';
    }
}
