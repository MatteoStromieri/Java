import java.util.HashMap;

public class PersonArchive {
    public HashMap<String,Person> personArchive;

    public PersonArchive() {
        this.personArchive = new HashMap<>();
    }

    public void inserisciPersona(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String matricola, int livello, String mansione) throws PersonaGiaPresenteException, DataNonValidaException, AnnoNonValidoException {
        if(this.personArchive.containsKey(codiceFiscale)){
            throw new PersonaGiaPresenteException(codiceFiscale);
        }
        this.personArchive.put(codiceFiscale,new Impiegato(nome, cognome, giorno, mese, anno, codiceFiscale, matricola, livello, mansione));
    }

    public void inserisciPersona(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String professione, String partitaIva) throws PersonaGiaPresenteException, DataNonValidaException, AnnoNonValidoException {
        if(this.personArchive.containsKey(codiceFiscale)){
            throw new PersonaGiaPresenteException(codiceFiscale);
        }
        this.personArchive.put(codiceFiscale, new LiberoProfessionista(nome, cognome, giorno, mese, anno, codiceFiscale, professione, partitaIva));
    }

    public void inserisciPersona(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale, String iscrizioneRegistroDisoccupazione) throws PersonaGiaPresenteException, DataNonValidaException, AnnoNonValidoException {
        if(this.personArchive.containsKey(codiceFiscale)){
            throw new PersonaGiaPresenteException(codiceFiscale);
        }
        this.personArchive.put(codiceFiscale,new Disoccupato(nome, cognome, giorno, mese, anno, codiceFiscale, iscrizioneRegistroDisoccupazione));
    }

    public Person getPersona(String codiceFiscale) throws PersonaInesistenteException {
        if(!this.personArchive.containsKey(codiceFiscale)){
            throw new PersonaInesistenteException(codiceFiscale);
        }
        return this.personArchive.get(codiceFiscale);
    }
}
