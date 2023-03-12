import java.util.Objects;

public class Ingrediente {
    public String nome;
    public double costo;
    public boolean privato;

    public Ingrediente(String nome, double costo, boolean privato) {
        this.nome = nome;
        this.costo = costo;
        this.privato = privato;
    }

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isPrivato() {
        return privato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return Double.compare(that.costo, costo) == 0 && privato == that.privato && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, costo, privato);
    }
}
