import java.util.ArrayList;
import java.util.Objects;

public class Utente {
    public String nome;
    public String cognome;
    public Data dataDiNascita;
    public String mail;
    public ArrayList<Utente> richiesteDiAmicizia;
    public ArrayList<Utente> amici;

    public Utente(String nome, String cognome, int giorno, int mese, int anno, String mail) throws DataNonValidaException {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = new Data(giorno,mese,anno);
        this.mail = mail;
        this.richiesteDiAmicizia = new ArrayList<>();
        this.amici = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Data getDataDiNascita() {
        return dataDiNascita;
    }

    public String getMail() {
        return mail;
    }

    public ArrayList<Utente> getRichiesteDiAmicizia() {
        return richiesteDiAmicizia;
    }

    public ArrayList<Utente> getAmici() {
        return amici;
    }

    public void inviaRichiesta(Utente destinatario){
        destinatario.getRichiesteDiAmicizia().add(this);
    }
    public void accettaAmicizia(Utente utente) throws RichiestaInesistenteException {
        if(!this.richiesteDiAmicizia.contains(utente)){
            throw new RichiestaInesistenteException(utente);
        }
        this.richiesteDiAmicizia.remove(utente);
        //eccezione per vedere se l'utente non è gia amico
        this.amici.add(utente);
        utente.getAmici().add(this);
    }

    public void rifiutaAmicizia(Utente utente) throws RichiestaInesistenteException {
        if(!this.richiesteDiAmicizia.contains(utente)){
            throw new RichiestaInesistenteException(utente);
        }
        this.richiesteDiAmicizia.remove(utente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome) && Objects.equals(dataDiNascita, utente.dataDiNascita) && Objects.equals(mail, utente.mail) && Objects.equals(richiesteDiAmicizia, utente.richiesteDiAmicizia) && Objects.equals(amici, utente.amici);
    }


    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, dataDiNascita, mail, richiesteDiAmicizia, amici);
    }
}
