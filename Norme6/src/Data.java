public class Data {
    public int giorno;
    public int mese;
    public int anno;

    public Data(int giorno, int mese, int anno) throws DataNonValidaException {
        if( giorno < 1 || giorno > 31 || mese < 1 || mese > 12 ){
            throw new DataNonValidaException();
        }
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public int getGiorno() {
        return giorno;
    }

    public int getMese() {
        return mese;
    }

    public int getAnno() {
        return anno;
    }

    @Override
    public String toString() {
        return giorno + "-" + mese +
                "-" + anno;
    }
}
