import java.util.ArrayList;
import java.util.HashMap;

public class Ludoteca {
    public HashMap<Data,ArrayList<Utilizzo>> utilizziConclusi;
    public ArrayList<Utilizzo> utilizziNonConclusi;
    public HashMap<Prodotto,Integer> magazzino;

    Ludoteca(){
        this.utilizziConclusi = new HashMap<>();
        this.utilizziNonConclusi = new ArrayList<>();
        this.magazzino = new HashMap<>();
    }

    public void addProdotto(String tipologia, String titolo, String autore, String casaEditrice, int annoPubblicazione, int parametro) throws TipologiaNonEsistenteException {

        Prodotto prodotto;

        if(tipologia.equals("Gioco")){
            prodotto = new Gioco(titolo,autore,casaEditrice,annoPubblicazione,parametro);
        } else if (tipologia.equals("Libro")) {
            prodotto = new Libro(titolo,autore,casaEditrice,annoPubblicazione,parametro);
        } else{
            throw new TipologiaNonEsistenteException(tipologia);
        }

        if(magazzino.containsKey(prodotto)){
            magazzino.put(prodotto, magazzino.get(prodotto) + 1);
        }else{
            magazzino.put(prodotto, 1 );
        }
    }

    public void inizioPrestito(Prodotto prodotto, int oraInizio, String nome, String cognome) throws ProdottoNonPresenteInMagazzinoException, ProdottoMancanteException, ProdottoNonDisponibileException {
        if(!magazzino.containsKey(prodotto)){
            throw new ProdottoMancanteException(prodotto);
        }

        if(magazzino.get(prodotto) == 0 ){
            throw new ProdottoNonDisponibileException(prodotto);
        }

        Utilizzo utilizzo = new Utilizzo(prodotto, oraInizio, nome, cognome);

        utilizziNonConclusi.add(utilizzo);
    }

    public void terminaPrestito(Utilizzo utilizzo, int oraFine, Data data) throws UtilizzoNonEsistenteException {
        if(!utilizziNonConclusi.contains(utilizzo)){
            throw new UtilizzoNonEsistenteException(utilizzo);
        }
        utilizziNonConclusi.remove(utilizzo);
        utilizzo.setOraFine(oraFine); //eccezion per dire che l'ora deve essere compresa tra 0 e 23

        if(!utilizziConclusi.containsKey(data)){
            utilizziConclusi.put(data, new ArrayList<>());
        }
        utilizziConclusi.get(data).add(utilizzo);
    }

    public boolean richiesta(Prodotto prodotto) throws ProdottoMancanteException {
        if(magazzino.get(prodotto) > 0 ){
            return true;
        }else if ( magazzino.get(prodotto) == 0 ){
            return false;
        }else{
            throw new ProdottoMancanteException(prodotto);
        }
    }

    public int richiestaGioco(Gioco prodotto) throws ProdottoMancanteException {
        if(richiesta(prodotto) == false ){
            return prodotto.getDurataMediaPartita();
        }
        return 0;
    }

    public int periodoPiuLungo(){
        int maxPeriodo = 0;
        for(ArrayList<Utilizzo> a : utilizziConclusi.values()){
            for( Utilizzo u : a ){
                maxPeriodo = Integer.max(maxPeriodo, u.getOraFine() - u.getOraInizio());
            }
        }
        return maxPeriodo;
    }
}
