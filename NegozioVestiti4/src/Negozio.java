import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Negozio {
    HashSet<Prodotto> magazzino;
    HashSet<Cliente> clienti;

    Negozio(){
        this.magazzino = new HashSet<>();
        this.clienti = new HashSet<>();
    }

    public HashSet<Prodotto> getMagazzino() {
        return magazzino;
    }

    public HashSet<Cliente> getClienti() {
        return clienti;
    }

    public void addProdotto(String nome, String categoria, Destinatario destinatario, String fornitore, double prezzo, int numeroProdotti) throws ValoriNonValidiException {
        Prodotto prodotto = new Prodotto(nome,categoria,destinatario,fornitore,prezzo,numeroProdotti);
        magazzino.add(prodotto);
    }

    public void addCliente(String nome, String indirizzo){
        Cliente cliente = new Cliente(nome,indirizzo);
        clienti.add(cliente);
    }

    public void addAcquisto(int giorno, int mese, int anno, Cliente cliente, Prodotto[] prodotti ) throws ProdottoNonPresenteException, ClienteInesistenteException, DataNonValidaException, AcquistoGiaEsistenteException {

        //controllo che tutti i prodotti siano in magazzino
        for(int i = 0 ; i < prodotti.length ; i++ ){
            if(!magazzino.contains(prodotti[i])){
                throw new ProdottoNonPresenteException();
            }
        }

        //controllo che il cliente sia un cliente del negozio
        if(!clienti.contains(cliente)){
            throw new ClienteInesistenteException(cliente);
        }
        cliente.addAcquisto(new Acquisto(new Data(giorno, mese, anno), new ArrayList<>(Arrays.asList(prodotti))));
    }

    public ArrayList<Prodotto> prodottiVenduti(Cliente cliente, Data data) throws ClienteInesistenteException {
        if(!clienti.contains(cliente)){
            throw new ClienteInesistenteException(cliente);
        }

        ArrayList<Prodotto> out = new ArrayList<>();

        for( Acquisto a : cliente.getAcquisti()){
            if( a.getData().equals(data)){
                out.addAll(a.getProdottiAcquistati());
            }
        }

        return out;
    }

    public int numeroVendite(Prodotto prodotto) throws ProdottoNonPresenteException {
        if(!magazzino.contains(prodotto)){
            throw new ProdottoNonPresenteException();
        }

        int n = 0;

        for(Cliente c : clienti){
            for(Acquisto a : c.getAcquisti()){
                for(Prodotto p : a.getProdottiAcquistati()){
                    if(p.equals(prodotto)){
                        n += 1;
                    }
                }
            }
        }
        return n;
    }

    public String fornitoreVincente() throws ProdottoNonPresenteException {
        HashMap<String,Integer> fornitoreNumeroVendite = new HashMap<>();
        HashMap<String,Integer> fornitoreProdottiForniti  = new HashMap<>();

        for(Prodotto p : magazzino){
            fornitoreNumeroVendite.put(p.getFornitore(),numeroVendite(p));
            fornitoreProdottiForniti.put(p.getFornitore(), fornitoreProdottiForniti.get(p.getFornitore()) + p.getNumeroProdotti());
        }

        String fornitoreVincente = null;
        int n = 0;

        for(String fornitore : fornitoreNumeroVendite.keySet()) {
            if (fornitoreNumeroVendite.get(fornitoreVincente) / fornitoreProdottiForniti.get(fornitoreVincente) > n) {
                fornitoreVincente = fornitore;
                n = fornitoreNumeroVendite.get(fornitoreVincente) / fornitoreProdottiForniti.get(fornitoreVincente);
            }
        }
        return fornitoreVincente;
    }

    public Prodotto prodottoPiuVenduto(int anno){
        HashMap<Prodotto,Integer> contaVenduti = new HashMap<>();

        for(Prodotto p : magazzino){
            contaVenduti.put(p,0);
        }

        for(Cliente c : clienti){
            for(Acquisto a : c.getAcquisti()){
                for(Prodotto p : a.getProdottiAcquistati()){
                    contaVenduti.put(p,contaVenduti.get(p) + 1);
                }
            }
        }
        Prodotto prodottoMax = null;
        int n = 0;

        for( Prodotto p : contaVenduti.keySet()){
            if(contaVenduti.get(p) >= n ){
                prodottoMax = p;
                n = contaVenduti.get(p);
            }
        }
        return prodottoMax;
    }

    
}
