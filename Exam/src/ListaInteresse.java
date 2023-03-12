import java.util.HashMap;
import java.util.HashSet;

public class ListaInteresse {
    public String interesse;
    public HashMap<String,Annuncio> annunci;
    public HashSet<Utente> utenti;

    public ListaInteresse(String interesse) {
        this.interesse = interesse;
        this.annunci = new HashMap<>();
        this.utenti = new HashSet<>();
    }

    public String getInteresse() {
        return interesse;
    }

    public HashMap<String, Annuncio> getAnnunci() {
        return annunci;
    }

    public HashSet<Utente> getUtenti() {
        return utenti;
    }

    public void inserisciUtente(Utente u){
        utenti.add(u);
    }

    public void inserisciAnnuncio(String titolo, String corpo, int giorno, int mese, int anno, Utente creatore) throws DataNonValidaException, UtenteNonRegistratoAllaListaException {
        if(!this.utenti.contains(creatore)){
            throw new UtenteNonRegistratoAllaListaException(creatore,this);
        }
        this.annunci.put(titolo,new Annuncio(titolo, corpo, giorno, mese, anno,creatore));
    }

    public Annuncio getAnnuncio(String titolo) throws AnnuncioInesistenteException {
        if(!this.annunci.containsKey(titolo)){
            throw new AnnuncioInesistenteException(titolo);
        }
        return this.annunci.get(titolo);
    }

    public void rimuoviAnnuncio(Annuncio annuncio,Utente u) throws AnnuncioInesistenteException, UtenteNonAutorizzatoAllaRimozioneException {
        if(!this.annunci.containsKey(annuncio.getTitolo())){
            throw new AnnuncioInesistenteException(annuncio.getTitolo());
        }
        if(!annuncio.getCreatore().equals(u)){
            throw new UtenteNonAutorizzatoAllaRimozioneException(u,annuncio);
        }
        annunci.remove(annuncio.getTitolo(),annuncio);
    }

}
