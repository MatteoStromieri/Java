import java.util.ArrayList;
import java.util.HashMap;

public class Biglietteria {
    public HashMap<String, ArrayList<Tratta>> tratte;

    public Biglietteria() {
        this.tratte = new HashMap<>();
    }

    public void addTratta(double lunghezza, String tipologia, String classe, String partenza, String arrivo) throws StazioniNonValideException, TrattaGiaEsistenteException {
        Tratta tratta = new Tratta(lunghezza, tipologia, classe, partenza, arrivo);
        if(!tratte.containsKey(partenza)){
            tratte.put(partenza,new ArrayList<Tratta>());
            tratte.get(partenza).add(tratta);
        }else{
            if(tratte.get(partenza).contains(tratta)){
                throw new TrattaGiaEsistenteException(tratta);
            }
            tratte.get(partenza).add(tratta);
        }
    }

    //public Biglietto generaBiglietto(String partenza,String arrivo){};
}
