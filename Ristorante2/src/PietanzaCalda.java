public class PietanzaCalda extends Pietanza {
    public double tempoSulFuoco;

    public PietanzaCalda(String nome, Ingrediente[] ingredienti, double[] quantita, double tempoPreparazione, String portata, double costoMano, double fattoreGuadagno, double tempoSulFuoco, double costoGas) throws ArrayInseritiNonValidiException {
        super(nome, ingredienti, quantita, tempoPreparazione, portata, costoMano, fattoreGuadagno);
        this.tempoSulFuoco = tempoSulFuoco;
        this.setPrezzo(this.getPrezzo() + this.tempoSulFuoco*costoGas);
    }

    public double getTempoSulFuoco() {
        return tempoSulFuoco;
    }


}
