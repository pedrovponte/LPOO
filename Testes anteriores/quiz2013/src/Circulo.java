public class Circulo extends Figura {
    private Ponto centro;
    private int raio;

    public Circulo(Ponto centro, int raio) throws IllegalArgumentException {
        if (raio < 0)
            throw new IllegalArgumentException();
        this.centro = centro;
        this.raio = raio;
    }

    public Ponto getCentro() {
        return centro;
    }

    public void setCentro(Ponto centro) {
        this.centro = centro;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * this.getRaio() * this.getRaio();
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * this.getRaio();
    }
}
