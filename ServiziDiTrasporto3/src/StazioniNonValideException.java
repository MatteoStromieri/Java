public class StazioniNonValideException extends Exception {
    public StazioniNonValideException(String partenza, String arrivo) {
        super("Non esiste una tratta con partenza: " + partenza + " e arrivo: " + arrivo);
    }
}
