public class UtenteInesistenteException extends Exception {
    public UtenteInesistenteException(String mail) {
        super("Non esiste un account associato alla mail: " + mail);
    }
}
