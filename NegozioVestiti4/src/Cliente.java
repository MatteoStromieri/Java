import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    public String nome;
    public String indirizzo;
    public ArrayList<Acquisto> acquisti;

    public Cliente(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.acquisti = new ArrayList<Acquisto>();
    }

    public void addAcquisto(Acquisto acquisto) throws AcquistoGiaEsistenteException {
        if(this.acquisti.contains(acquisto)){
            throw new AcquistoGiaEsistenteException();
        }
        this.acquisti.add(acquisto);
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public ArrayList<Acquisto> getAcquisti() {
        return acquisti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nome, cliente.nome) && Objects.equals(indirizzo, cliente.indirizzo) && Objects.equals(acquisti, cliente.acquisti);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, indirizzo, acquisti);
    }
}
