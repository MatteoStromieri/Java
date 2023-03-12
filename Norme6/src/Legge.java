import java.util.ArrayList;
import java.util.HashMap;

public class Legge {
    public Tipologia tipologia;
    public Data data;
    public String introduzione;
    public String conclusione;
    public HashMap<Integer,Articolo> articoli;
    public ArrayList<Object> allegati;

    public Legge(String  tipologia, int giorno, int mese, int anno, String introduzione, String conclusione, HashMap<Integer, Articolo> articoli) throws DataNonValidaException {
        this.tipologia = Tipologia.valueOf(tipologia);
        this.data = new Data(giorno, mese, anno);
        this.introduzione = introduzione;
        this.conclusione = conclusione;
        this.articoli = articoli;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public Data getData() {
        return data;
    }

    public String getIntroduzione() {
        return introduzione;
    }

    public String getConclusione() {
        return conclusione;
    }

    public HashMap<Integer, Articolo> getArticoli() {
        return articoli;
    }

    public ArrayList<Object> getAllegati() {
        return allegati;
    }

    @Override
    public String toString() {
        return "Legge:"+this.tipologia+":"+this.data;
    }
}
