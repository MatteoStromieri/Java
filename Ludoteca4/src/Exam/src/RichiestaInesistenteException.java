public class RichiestaInesistenteException extends Exception{
    public RichiestaInesistenteException(Utente u) {
        super("L'utente con mail " + u.getMail() + " non ha inviato una richiesta all'utente considerato");
    }
}
