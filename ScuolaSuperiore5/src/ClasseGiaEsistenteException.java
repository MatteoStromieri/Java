public class ClasseGiaEsistenteException extends Throwable {
    public ClasseGiaEsistenteException(String s) {
        super("E' già presente una classe dal nome: " + s + "\n");
    }
}
