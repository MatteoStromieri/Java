import java.util.Objects;

public class Pair {
    Tipologia tipologia;
    Data data;

    public Pair(Tipologia tipologia, Data data) {
        this.tipologia = tipologia;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return tipologia == pair.tipologia && data.equals(pair.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipologia, data);
    }
}
