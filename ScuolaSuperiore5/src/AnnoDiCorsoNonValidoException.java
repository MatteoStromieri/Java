public class AnnoDiCorsoNonValidoException extends Exception {
    public AnnoDiCorsoNonValidoException(int annoDiCorso) {
        super("Anno di corso inserito: " + annoDiCorso + " errato. L'anno di corso deve essere compreso tra 1 e 5");
    }
}
