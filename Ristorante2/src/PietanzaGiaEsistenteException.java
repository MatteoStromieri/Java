public class PietanzaGiaEsistenteException extends Exception {
    public PietanzaGiaEsistenteException(String nome) {
        super("Nel menu è gia presente la pietanza: " + nome + "\n");
    }
}
