public class CostiRistorantenNonValidiException extends Exception {
    CostiRistorantenNonValidiException(){
        super("Non sono ammessi costi e/o fattore negativo nella definizione del ristorante");
    }
}
