import java.util.HashMap;

public class Pietanza {
    public String nome;
    public double prezzo;
    public HashMap<Ingrediente, Double> ingredienti;
    public double tempoPreparazione;
    public Portata portata;

    public Pietanza(String nome, Ingrediente[] ingredienti, double[] quantita, double tempoPreparazione, String portata, double costoMano, double fattoreGuadagno) throws ArrayInseritiNonValidiException {

        if(ingredienti.length != quantita.length){
            throw new ArrayInseritiNonValidiException();
        }

        this.nome = nome;
        this.ingredienti = new HashMap<>();
        this.tempoPreparazione = tempoPreparazione;
        this.portata = Portata.valueOf(portata);

        //inseriamo i dati nella HashMap
        for( int i = 0; i < ingredienti.length ; i++){
            this.ingredienti.put(ingredienti[i],quantita[i]);
        }

        //definiamo il prezzo
        this.prezzo = this.getCostoIngredienti() + this.tempoPreparazione*costoMano + fattoreGuadagno;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public HashMap<Ingrediente, Double> getIngredienti() {
        return ingredienti;
    }

    public double getTempoPreparazione() {
        return tempoPreparazione;
    }

    public Portata getPortata() {
        return portata;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getCostoIngredienti(){
        double costo = 0;
        for(Ingrediente i : this.ingredienti.keySet()){
            costo += i.getCosto()*this.ingredienti.get(i);
        }
        return costo;
    }

    public String mostraIngredientiPubblici(){
        String output = "";
        for(Ingrediente i : ingredienti.keySet()){
            if(!i.isPrivato()){
                 output += i.getNome() + "\n";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                "prezzo=" + prezzo + '\'' +
                this.mostraIngredientiPubblici();
    }
}


