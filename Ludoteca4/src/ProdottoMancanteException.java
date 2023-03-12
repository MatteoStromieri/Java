public class ProdottoMancanteException extends Exception {
    public ProdottoMancanteException(Prodotto prodotto) {
        super("Il prodotto seguente non è presente in magazzino \n " + prodotto);
    }
}
