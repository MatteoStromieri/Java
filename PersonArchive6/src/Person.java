public abstract class Person {
    public String nome;
    public String cognome;
    public Data dataDiNascita;
    public String codiceFiscale;

    public Person(String nome, String cognome, int giorno, int mese, int anno, String codiceFiscale) throws AnnoNonValidoException, DataNonValidaException {

        if( anno < 1900 ){
            throw new AnnoNonValidoException();
        }

        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = new Data(giorno,mese,anno);
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Data getDataDiNascita() {
        return dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }
}
