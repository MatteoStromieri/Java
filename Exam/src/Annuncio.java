import java.util.Objects;

public class Annuncio {
    public String titolo;
    public String corpo;
    public Data dataInseriemnto;
    public Utente creatore;

    public Annuncio(String titolo, String corpo, int giorno, int mese, int anno,Utente creatore) throws DataNonValidaException {
        this.titolo = titolo;
        this.corpo = corpo;
        this.dataInseriemnto = new Data(giorno, mese, anno);
        this.creatore = creatore;
    }

    public Utente getCreatore() {
        return creatore;
    }
    public String getTitolo() {
        return titolo;
    }

    public String getCorpo() {
        return corpo;
    }

    public Data getDataInseriemnto() {
        return dataInseriemnto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annuncio annuncio = (Annuncio) o;
        return Objects.equals(titolo, annuncio.titolo) && Objects.equals(corpo, annuncio.corpo) && Objects.equals(dataInseriemnto, annuncio.dataInseriemnto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, corpo, dataInseriemnto);
    }
}
