public class PersonaGiaPresenteException extends Exception {
    public PersonaGiaPresenteException(String codiceFiscale) {
        super(codiceFiscale + " è già presente in archivio");
    }
}
