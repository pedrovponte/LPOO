import java.util.Objects;

public class Ponto implements Comparable{
    private int x;
    private int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return x == ponto.x &&
                y == ponto.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Object object) {
        if(this.getX() > ((Ponto) object).getX()) return 1;
        if(this.getX() < ((Ponto) object).getX()) return -1;
        if(this.getY() > ((Ponto) object).getX()) return 1;
        return -1;
    }
}
