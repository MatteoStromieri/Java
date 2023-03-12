public class Disoccupato extends Person{
    public String iscrizioneRegistroDisoccupazione;

    public Disoccupato(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String iscrizioneRegistroDisoccupazione) throws AnnoNonValidoException, DataNonValidaException {
        super(nome, cognome, giorno, mese, anno, codiceFiscale);
        this.iscrizioneRegistroDisoccupazione = iscrizioneRegistroDisoccupazione;
    }

    public String getIscrizioneRegistroDisoccupazione() {
        return iscrizioneRegistroDisoccupazione;
    }
}
