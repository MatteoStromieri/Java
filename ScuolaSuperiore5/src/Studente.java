import java.util.Objects;

public class Studente {
    public String nome;
    public String cognome;
    public String luogoNascita;
    public Data dataNascita;
    public int annoIscrizione;

    public Studente(String nome, String cognome, String luogoNascita, int giorno, int mese, int anno, int annoIscrizione) throws DataNonValidaException {
        //annoiscriozione > anno

        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = new Data(giorno, mese, anno);
        this.annoIscrizione = annoIscrizione;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public Data getDataNascita() {
        return dataNascita;
    }

    public int getAnnoIscrizione() {
        return annoIscrizione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studente studente = (Studente) o;
        return annoIscrizione == studente.annoIscrizione && Objects.equals(nome, studente.nome) && Objects.equals(cognome, studente.cognome) && Objects.equals(luogoNascita, studente.luogoNascita) && Objects.equals(dataNascita, studente.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, luogoNascita, dataNascita, annoIscrizione);
    }
}
