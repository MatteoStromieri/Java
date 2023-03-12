import java.util.HashMap;

public class Articolo {
    public String introduzione;
    public HashMap<Integer,String> commi;

    public Articolo(String introduzione, String[] commi) {
        this.introduzione = introduzione;
        this.commi = new HashMap<>();
        for(int i = 0; i < commi.length; i++){
            this.commi.put(i,commi[i]);
        }
    }

    public String getIntroduzione() {
        return introduzione;
    }

    public HashMap<Integer, String> getCommi() {
        return commi;
    }
}
