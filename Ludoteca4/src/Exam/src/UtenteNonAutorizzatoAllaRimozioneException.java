public class UtenteNonAutorizzatoAllaRimozioneException extends Exception {
    public UtenteNonAutorizzatoAllaRimozioneException(Utente u, Annuncio annuncio) {
        super("L'utente com mail " + u.getMail() + " non è il creatore dell'annuncio " + annuncio.getTitolo() + " quindi non è autorizzato a rimuoverlo");
    }
}
