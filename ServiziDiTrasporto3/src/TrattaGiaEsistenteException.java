public class TrattaGiaEsistenteException extends Throwable {
    public TrattaGiaEsistenteException(Tratta tratta) {
        super("la tratta seguente giù è presente in archivio: \n" + tratta + "\n");
    }
}
