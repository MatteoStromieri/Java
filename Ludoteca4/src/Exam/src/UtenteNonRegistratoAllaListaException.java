public class UtenteNonRegistratoAllaListaException extends Throwable {
    public UtenteNonRegistratoAllaListaException(Utente creatore, ListaInteresse listaInteresse) {
        super("L'utente " + creatore + " non è registrato alla lista " + listaInteresse.getInteresse());
    }
}
