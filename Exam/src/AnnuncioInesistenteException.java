public class AnnuncioInesistenteException extends Exception {
    public AnnuncioInesistenteException(String titolo) {
        super("Nella lista considerata non esiste annuncio dal titolo " + titolo);
    }
}
