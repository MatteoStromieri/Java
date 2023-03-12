import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
    HashMap<String,Utente> utenti; //mail - utente
    HashMap<String,ListaInteresse> listeInteressi;

    public Sistema() {
        this.utenti = new HashMap<>();
        this.listeInteressi = new HashMap<>();
    }

    public HashMap<String, Utente> getUtenti() {
        return utenti;
    }

    public HashMap<String, ListaInteresse> getListeInteressi() {
        return listeInteressi;
    }

    public void inserisciUtente(String nome, String cognome, int giorno, int mese, int anno, String mail) throws UtenteEsistenteException, DataNonValidaException {
        if(utenti.containsKey(mail)){
            throw new UtenteEsistenteException(mail);
        }
        this.utenti.put(mail,new Utente(nome, cognome, giorno, mese, anno, mail));
    }

    public void rimuoviUtente(String mail) throws UtenteInesistenteException {
        if(!utenti.containsKey(mail)){
            throw new UtenteInesistenteException(mail);
        }
        utenti.remove(mail);
    }
    //overload del metodo precedente, questa volta abbiamo come parametro l'utente stesso
    public void rimuoviUtente(Utente u) throws UtenteInesistenteException {
        if(!utenti.containsKey(u.getMail())){
            throw new UtenteInesistenteException(u.getMail());
        }
        utenti.remove(u.getMail());
    }

    public void nuovaRichiestaAmicizia(Utente richiedente,Utente destinatario) throws UtenteInesistenteException {
        if(!this.utenti.containsKey(richiedente.getNome())){
            throw new UtenteInesistenteException(richiedente.getMail());
        }
        if(!this.utenti.containsKey(destinatario.getNome())){
            throw new UtenteInesistenteException(destinatario.getMail());
        }
        richiedente.inviaRichiesta(destinatario);
    }

    public void accettaRichiesta(Utente richiedente, Utente destinatario) throws RichiestaInesistenteException {
        destinatario.accettaAmicizia(richiedente);
    }

    public void rifiutaRichiesta(Utente richiedente, Utente destinatario) throws RichiestaInesistenteException {
        destinatario.rifiutaAmicizia(richiedente);
    }

    public void creaListaInteresse(String interesse) throws ListaInteresseGiaEsistenteException {
        if(this.listeInteressi.containsKey(interesse)){
            throw new ListaInteresseGiaEsistenteException(interesse);
        }
        this.listeInteressi.put(interesse,new ListaInteresse(interesse));
    }

    public void inserisciAnnuncio(Utente u,String nomeLista,String titolo, String corpo, int giorno, int mese, int anno) throws UtenteInesistenteException, ListaInteresseInesistenteException, DataNonValidaException, UtenteNonRegistratoAllaListaException {
        if(!this.utenti.containsKey(u)){
            throw new UtenteInesistenteException(u.getMail());
        }
        if(!this.listeInteressi.containsKey(nomeLista)){
            throw new ListaInteresseInesistenteException(nomeLista);
        }
        if(!this.listeInteressi.get(nomeLista).getUtenti().contains(u)){
            throw new UtenteNonRegistratoAllaListaException(u,this.listeInteressi.get(nomeLista));
        }
        this.listeInteressi.get(nomeLista).inserisciAnnuncio(titolo, corpo, giorno, mese, anno,u);
    }

    public void inserisciUtenteLista(Utente u,String nomeLista) throws UtenteInesistenteException, ListaInteresseInesistenteException {
        if(!this.utenti.containsKey(u)){
            throw new UtenteInesistenteException(u.getMail());
        }
        if(!this.listeInteressi.containsKey(nomeLista)){
            throw new ListaInteresseInesistenteException(nomeLista);
        }
        this.listeInteressi.get(nomeLista).inserisciUtente(u);
    }

    public ArrayList<Annuncio> ricercaAnnuncio(String titolo) throws ListaInteresseInesistenteException, AnnuncioInesistenteException {

        ArrayList<Annuncio> annunci = new ArrayList<>();

        for(ListaInteresse l : listeInteressi.values()){
            for(Annuncio a : l.getAnnunci().values()){
                if(a.getTitolo().contains(titolo)){
                    annunci.add(a);
                }
            }
        }
        return annunci;
    }

    public void mostraListeInteresse(){
        for(String nomeLista : this.listeInteressi.keySet()){
            System.out.println(nomeLista + "\n");
        }
    }

    public void rimuoviAnnuncio(Annuncio annuncio,String listaNome,Utente u) throws ListaInteresseInesistenteException, AnnuncioInesistenteException, UtenteNonAutorizzatoAllaRimozioneException {
        if(!this.listeInteressi.containsKey(listaNome)){
            throw new ListaInteresseInesistenteException(listaNome);
        }
        this.listeInteressi.get(listaNome).rimuoviAnnuncio(annuncio,u);
    }
}
