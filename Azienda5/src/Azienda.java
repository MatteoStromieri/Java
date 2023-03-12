import java.util.ArrayList;
import java.util.HashMap;

public class Azienda {
    public HashMap<String,Dipendente> dipendenti;

    public Azienda() {
        this.dipendenti = new HashMap<>();
    }

    public void addImpiegato(String nome, String cognome, int giornoNascita, int meseNascita, int annoNascita, int giornoAssunzione, int meseAssunzione, int annoAssunzione, String dipartimento, String mansione, int livello, String matrCapo) throws DipendenteInesistenteException, DipendenteGiaEsistenteException, DataNonValidaException, LivelloNonValidoException {
        if(!dipendenti.containsKey(matrCapo)){
            throw new DipendenteInesistenteException(matrCapo);
        }
        Dipendente dipendente = new Dipendente(nome,cognome,new Data(giornoNascita,meseNascita,annoNascita), new Data(giornoAssunzione,meseAssunzione,annoAssunzione), Dipartimento.valueOf(dipartimento), mansione, livello, dipendenti.get(matrCapo));
        if(dipendenti.containsKey(dipendente.getMatricola())){
            throw new DipendenteGiaEsistenteException(dipendente.getMatricola());
        }
        dipendenti.put(dipendente.getMatricola(), dipendente);
    }

    public HashMap<Integer,Dipendente> chainOfCommand(String matricola) throws DipendenteInesistenteException {
        if(!dipendenti.containsKey(matricola)){
            throw new DipendenteInesistenteException(matricola);
        }
        Dipendente capo = dipendenti.get(matricola);
        HashMap<Integer,Dipendente> chain = new HashMap<>();
        int i = 0;

        while(capo.getCapo() != null){
            chain.put(i,capo.getCapo());
            i += 1;
            capo = capo.getCapo();
        }
        return chain;
    }

    private ArrayList<Dipendente> getFigli(Dipendente dipendente) throws DipendenteInesistenteException {
        HashMap<Integer,Dipendente> chain;
        ArrayList<Dipendente> output = new ArrayList<>();
        for(String matricola : dipendenti.keySet()){
            chain = chainOfCommand(matricola);
            if(chain.values().contains(dipendente)){
                output.add(dipendenti.get(matricola));
            }
        }
        return output;
    }

    public String sostituto(String matricola) throws DipendenteInesistenteException, ImpiegatoInsostituibileException {
        if(!dipendenti.containsKey(matricola)){
            throw new DipendenteInesistenteException(matricola);
        }
        ArrayList<Dipendente> figli;
        HashMap<Integer,Dipendente> chain = chainOfCommand(matricola);
        for(int i = 0; chain.containsKey(i); i++){
            for(Dipendente dip : getFigli(chain.get(i))){
                if(dip.getMansione().equals(dipendenti.get(matricola).getMansione())){
                    return dip.getMatricola();
                }
            }
        }
        throw new ImpiegatoInsostituibileException(matricola);
    }
}
