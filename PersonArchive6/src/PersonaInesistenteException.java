public class PersonaInesistenteException extends Exception {
    public PersonaInesistenteException(String codiceFiscale) {
        super("Persona con codice fiscale: " + codiceFiscale + " non presente in archivio");
    }
}
