public class AnnoNonValidoException extends Exception {
    AnnoNonValidoException(){
        super("Non sono ammessi anni precedenti al 1900");
    }
}
