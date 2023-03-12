public class Impiegato extends Person{
    public String matricola;
    public int livello;
    public String mansione;

    public Impiegato(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String matricola, int livello, String mansione) throws AnnoNonValidoException, DataNonValidaException {
        super(nome, cognome, giorno, mese, anno, codiceFiscale);
        this.matricola = matricola;
        this.livello = livello;
        this.mansione = mansione;
    }

    public String getMatricola() {
        return matricola;
    }

    public int getLivello() {
        return livello;
    }

    public String getMansione() {
        return mansione;
    }
}
