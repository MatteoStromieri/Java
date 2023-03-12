public class LiberoProfessionista extends Person {
    public String professione;
    public String partitaIva;

    public LiberoProfessionista(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String professione, String partitaIva) throws AnnoNonValidoException, DataNonValidaException {
        super(nome, cognome, giorno, mese, anno, codiceFiscale);
        this.professione = professione;
        this.partitaIva = partitaIva;
    }

    public String getProfessione() {
        return professione;
    }

    public String getPartitaIva() {
        return partitaIva;
    }
}
