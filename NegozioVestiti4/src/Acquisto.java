import java.util.ArrayList;
import java.util.Objects;

public class Acquisto {
    public Data data;
    public ArrayList<Prodotto> prodottiAcquistati;

    public Acquisto(Data data, ArrayList<Prodotto> prodottiAcquistati) {
        this.data = data;
        this.prodottiAcquistati = prodottiAcquistati;
    }

    public Data getData() {
        return data;
    }

    public ArrayList<Prodotto> getProdottiAcquistati() {
        return prodottiAcquistati;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acquisto acquisto = (Acquisto) o;
        return Objects.equals(data, acquisto.data) && Objects.equals(prodottiAcquistati, acquisto.prodottiAcquistati);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, prodottiAcquistati);
    }
}
