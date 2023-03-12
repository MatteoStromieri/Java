import java.util.ArrayList;

public class Biglietto {
    public String partenza;
    public String arrivo;
    public ArrayList<Tratta> sequenzaTratte;
    public double prezzo;

    public Biglietto(String partenza, String arrivo, ArrayList<Tratta> sequenzaTratte) throws StazioniNonValideException {

        if(partenza.equals(arrivo)){
            throw new StazioniNonValideException(partenza,arrivo);
        }
        //controllare che le tratte portino effetivamente a destinazione

        this.partenza = partenza;
        this.arrivo = arrivo;
        this.sequenzaTratte = sequenzaTratte;
        this.prezzo = this.generaPrezzo(sequenzaTratte);
    }

    public String getPartenza() {
        return partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    public ArrayList<Tratta> getSequenzaTratte() {
        return sequenzaTratte;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double generaPrezzo(ArrayList<Tratta> tratte){
        //per ogni tratta guardo la lunghezza*costoCategoria*fattoreMoltClasse
        double prezzo = 0;
        for(Tratta i : tratte){
            prezzo += i.getLunghezza()*i.getTipologia().getCostoKm()*i.getClasse().getFattoreMoltiplicativo();
        }
        return prezzo;
    }
}
