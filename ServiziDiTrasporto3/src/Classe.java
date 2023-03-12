public enum Classe {
    NORMALE(1.0),
    CONFORT(1.3),
    DELUXE(1.7);

    private double fattoreMoltiplicativo;
    Classe(double v) {
    }

    public double getFattoreMoltiplicativo() {
        return fattoreMoltiplicativo;
    }
}
