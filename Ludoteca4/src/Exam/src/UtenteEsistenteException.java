public class UtenteEsistenteException extends Exception {
    public UtenteEsistenteException(String mail) {
        super("Già esiste una account associato alla mail: " + mail);
    }
}
