import java.util.HashMap;

public class Portale {
    public HashMap<Pair,Legge> leggi;

    public Portale() {
        this.leggi = new HashMap<>();
    }

    public void inserisciLegge(String  tipologia, int giorno, int mese, int anno, String introduzione, String conclusione, HashMap<Integer, Articolo> articoli) throws DataNonValidaException, LeggeGiaPresenteException {
        if(leggi.containsKey(new Pair(Tipologia.valueOf(tipologia), new Data(giorno, mese, anno)))){
            throw new LeggeGiaPresenteException();
        }
        leggi.put(new Pair(Tipologia.valueOf(tipologia), new Data(giorno, mese, anno)), new Legge(tipologia, giorno, mese, anno, introduzione, conclusione, articoli));
    }

    public Legge getLegge(String  tipologia, int giorno, int mese, int anno) throws LeggeInesistenteException, DataNonValidaException {
        Legge legge = leggi.get(new Pair(Tipologia.valueOf(tipologia), new Data(giorno, mese, anno)));
        if(legge == null ){
            throw new LeggeInesistenteException();
        }
        return legge;
    }

    public void leggiStessoAnno(int anno){
        for(Legge l : leggi.values()){
            if(l.getData().getAnno() == anno){
                System.out.println(l + "\n");
            }
        }
    }

    public void leggiNonConformi(){
        for(Legge l : leggi.values()){
            if(l.getArticoli().size() > 20){
                System.out.println(l + "\n");
            }
        }
    }
}
