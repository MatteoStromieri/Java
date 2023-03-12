import java.util.Objects;

public class Utilizzo {
    public Prodotto prodotto;
    public int oraInizio;
    public String nomeCliente;
    public String cognomeCliente;
    public int oraFine;

    public Utilizzo(Prodotto prodotto, int oraInizio, String nomeCliente, String cognomeCliente) {
        this.prodotto = prodotto;
        this.oraInizio = oraInizio;
        this.nomeCliente = nomeCliente;
        this.cognomeCliente = cognomeCliente;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getOraInizio() {
        return oraInizio;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCognomeCliente() {
        return cognomeCliente;
    }

    public int getOraFine() {
        return oraFine;
    }

    public void setOraFine(int oraFine) {
        this.oraFine = oraFine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizzo utilizzo = (Utilizzo) o;
        return oraInizio == utilizzo.oraInizio && oraFine == utilizzo.oraFine && Objects.equals(prodotto, utilizzo.prodotto) && Objects.equals(nomeCliente, utilizzo.nomeCliente) && Objects.equals(cognomeCliente, utilizzo.cognomeCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodotto, oraInizio, nomeCliente, cognomeCliente, oraFine);
    }
}
