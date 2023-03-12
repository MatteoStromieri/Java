import java.util.ArrayList;
import java.util.HashMap;

public class Scuola {
    HashMap<String,Classe> scuola;
    ArrayList<Studente> studenti;

    public Scuola() {
        this.scuola = new HashMap<>();
        this.studenti = new ArrayList<>();
    }

    public void addClasse(int annoDiNascita, int annoDiCorso, String sezione) throws ClasseGiaEsistenteException, AnnoDiCorsoNonValidoException {
        if(scuola.containsKey(annoDiCorso+sezione)){
            throw new ClasseGiaEsistenteException(annoDiCorso+sezione);
        }
        scuola.put(annoDiCorso+sezione,new Classe(annoDiNascita, annoDiCorso, sezione));
    }

    public void addStudente(String nomeClasse,String nome, String cognome, String luogoNascita, int giorno, int mese, int anno, int annoIscrizione) throws DataNonValidaException {
        Studente studente = new Studente(nome, cognome, luogoNascita, giorno, mese, anno, annoIscrizione);
        studenti.add(studente);
        scuola.get(nomeClasse).getStudenti().add(studente);
    }

    public int numeroStudenti(String nomeClasse) throws ClasseMancanteException {
        if(!scuola.containsKey(nomeClasse)){
            throw new ClasseMancanteException();
        }
        return scuola.get(nomeClasse).getStudenti().size();
    }

    public void ripetenti(String nomeClasse) throws ClasseMancanteException {
        if(!scuola.containsKey(nomeClasse)){
            throw new ClasseMancanteException();
        }
        for(Classe c : scuola.values()){
            for(Studente s : c.getStudenti()){
                if(s.getDataNascita().getAnno() < c.getAnnoDiNascita()){
                    System.out.println(s.getNome() + " " + s.getCognome() + " " + (c.getAnnoDiNascita() - s.getDataNascita().getAnno()) );
                }
            }
        }
    }
}
