import java.util.Objects;

public class Carruagem {
    private int numLugares;

    public Carruagem(int numLugares) {
        this.numLugares = numLugares;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public void setNumLugares(int numLugares) {
        this.numLugares = numLugares;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Carruagem carruagem = (Carruagem) object;
        return numLugares == carruagem.numLugares;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numLugares);
    }
}
