import java.util.HashMap;
import java.util.HashSet;

public class Ristorante {
    public HashMap<String,Pietanza> menu;
    public HashMap<String,Ingrediente> magazzino;
    public double costoMano;
    public double costoGas;
    public double fattoreGuadagno;

    public Ristorante(double costoMano, double costoGas, double fattoreGuadagno) throws CostiRistorantenNonValidiException {

        if(costoMano <= 0 || costoGas <= 0 || fattoreGuadagno <= 0 ){
            throw new CostiRistorantenNonValidiException();
        }


        this.menu = new HashMap<>();
        this.magazzino = new HashMap<>();
        this.costoMano = costoMano;
        this.costoGas = costoGas;
        this.fattoreGuadagno = fattoreGuadagno;
    }

    public void addPietanza( String nome, String[] ingredienti, double[] quantita,String portata, double tempoPreparazione) throws PietanzaGiaEsistenteException, IngredienteAssenteException, ArrayInseritiNonValidiException {
        if(menu.containsKey(nome)){
            throw new PietanzaGiaEsistenteException(nome);
        }
        //costruiamo l'array di ingredienti
        Ingrediente[] ingredientiArr = new Ingrediente[ingredienti.length];
        for(int i = 0; i < ingredienti.length ; i++){
            if(!magazzino.containsKey(ingredienti[i])){
                throw new IngredienteAssenteException(ingredienti[i]);
            }
            ingredientiArr[i] = this.magazzino.get(ingredienti[i]);
        }

        Pietanza pietanza = new Pietanza(nome,ingredientiArr,quantita,tempoPreparazione,portata,this.costoMano,this.fattoreGuadagno);

        menu.put(nome,pietanza);
    }

    public void addPietanza( String nome, String[] ingredienti, double[] quantita,String portata, double tempoPreparazione, double tempoSulFuoco) throws PietanzaGiaEsistenteException, IngredienteAssenteException, ArrayInseritiNonValidiException {
        if(menu.containsKey(nome)){
            throw new PietanzaGiaEsistenteException(nome);
        }
        //costruiamo l'array di ingredienti
        Ingrediente[] ingredientiArr = new Ingrediente[ingredienti.length];
        for(int i = 0; i < ingredienti.length ; i++){
            if(!magazzino.containsKey(ingredienti[i])){
                throw new IngredienteAssenteException(ingredienti[i]);
            }
            ingredientiArr[i] = this.magazzino.get(ingredienti[i]);
        }

        Pietanza pietanza = new PietanzaCalda(nome,ingredientiArr,quantita,tempoPreparazione,portata,this.costoMano,this.fattoreGuadagno, tempoSulFuoco, this.costoGas);

        menu.put(nome,pietanza);
    }

    public void presentaMenu(){
        for(Pietanza p : menu.values()){
            System.out.println(p);
        }
    }
}
