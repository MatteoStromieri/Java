public class ListaInteresseGiaEsistenteException extends Exception {
    public ListaInteresseGiaEsistenteException(String interesse) {
        super("Già esiste una lista di interesse dal nome : " + interesse);
    }
}
