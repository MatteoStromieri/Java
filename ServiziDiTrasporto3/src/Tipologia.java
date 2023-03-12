public enum Tipologia {
    NAZBLU(0.15),
    NAZGRIGIO(0.10),
    REGBLU(0.10),
    REGGRIGIO(0.08);

    private double costoKm;

    Tipologia(double v) {
    }

    public double getCostoKm() {
        return costoKm;
    }
}
