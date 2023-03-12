import java.util.Objects;

public class Prodotto {

    public String nome;
    public Categoria categoria;
    public Destinatario destinatario;
    public String fornitore;
    public double prezzo;
    public int numeroProdotti;

    public Prodotto(String nome, String categoria, Destinatario destinatario, String fornitore, double prezzo, int numeroProdotti) throws ValoriNonValidiException {

        if( numeroProdotti < 0 || prezzo < 0 ){
            throw new ValoriNonValidiException();
        }

        this.nome = nome;
        this.categoria = Categoria.valueOf(categoria);
        this.destinatario = destinatario;
        this.fornitore = fornitore;
        this.prezzo = prezzo;
        this.numeroProdotti = numeroProdotti;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public String getFornitore() {
        return fornitore;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getNumeroProdotti() {
        return numeroProdotti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Double.compare(prodotto.prezzo, prezzo) == 0 && numeroProdotti == prodotto.numeroProdotti && Objects.equals(nome, prodotto.nome) && categoria == prodotto.categoria && destinatario == prodotto.destinatario && Objects.equals(fornitore, prodotto.fornitore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, categoria, destinatario, fornitore, prezzo, numeroProdotti);
    }
}
