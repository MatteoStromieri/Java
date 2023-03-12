public class TipologiaNonEsistenteException extends Exception {
    public TipologiaNonEsistenteException(String tipologia) {
        super("Tipologia: " + tipologia + " inesistente \n");
    }
}
