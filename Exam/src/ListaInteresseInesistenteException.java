public class ListaInteresseInesistenteException extends Exception {
    public ListaInteresseInesistenteException(String nomeLista) {
        super("Non esiste una lista dal nome " + nomeLista);
    }
}
