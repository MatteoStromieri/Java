import java.util.ArrayList;

public class Classe {
    public int annoDiNascita;
    public int annoDiCorso;
    public String sezione;
    public String nome;
    public ArrayList<Studente> studenti;

    public Classe(int annoDiNascita, int annoDiCorso, String sezione) throws AnnoDiCorsoNonValidoException {
        if(annoDiCorso < 1 || annoDiCorso > 5){
            throw new AnnoDiCorsoNonValidoException(annoDiCorso);
        }
        this.annoDiNascita = annoDiNascita;
        this.annoDiCorso = annoDiCorso;
        this.sezione = sezione;
        this.nome = annoDiCorso+sezione;
        this.studenti = new ArrayList<>();
    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    public int getAnnoDiCorso() {
        return annoDiCorso;
    }

    public String getSezione() {
        return sezione;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Studente> getStudenti() {
        return studenti;
    }
}
