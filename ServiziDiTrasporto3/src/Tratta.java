public class Tratta {
    public double lunghezza;
    public Tipologia tipologia;
    public Classe classe;
    public String partenza;
    public String arrivo;

    public Tratta(double lunghezza, String tipologia, String classe, String partenza, String arrivo) throws StazioniNonValideException {

        if(partenza.equals(arrivo)){
            throw new StazioniNonValideException(partenza,arrivo);
        }
        //eccezione per la lunghezza negativa

        this.lunghezza = lunghezza;
        this.tipologia = Tipologia.valueOf(tipologia);
        this.classe = Classe.valueOf(classe);
        this.partenza = partenza;
        this.arrivo = arrivo;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public Classe getClasse() {
        return classe;
    }

    public String getPartenza() {
        return partenza;
    }

    public String getArrivo() {
        return arrivo;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "lunghezza=" + lunghezza +
                ", tipologia=" + tipologia +
                ", classe=" + classe +
                ", partenza='" + partenza + '\'' +
                ", arrivo='" + arrivo + '\'' +
                '}';
    }
}
