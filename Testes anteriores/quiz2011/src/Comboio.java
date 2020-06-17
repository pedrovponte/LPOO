import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comboio {
    private String nome;
    private List<Carruagem> carruagens;
    private int numPassageiros;
    private int lugaresLivres;
    private ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        this.carruagens = new ArrayList<>();
        this.numPassageiros = 0;
        this.lugaresLivres = 0;
        this.servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumLugares() {
        int lugares = 0;
        for(Carruagem carruagem : carruagens)
            lugares += carruagem.getNumLugares();
        return lugares;
    }

    public int getNumCarruagens() {
        return carruagens.size();
    }

    public void addCarruagem(Carruagem carruagem) {
        carruagens.add(carruagem);
        this.lugaresLivres += carruagem.getNumLugares();
    }

    public Carruagem getCarruagemByOrder(int i) {
        return carruagens.get(i);
    }

    public void removeAllCarruagens(int capacidade) {
        for(int i = 0; i < carruagens.size(); i++) {
            if(carruagens.get(i).getNumLugares() == capacidade)
                carruagens.remove(i);
        }
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public int getLugaresLivres() {
        return lugaresLivres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }

    public void addPassageiros(int numPassageiros) throws PassengerCapacityExceeded {
        if(numPassageiros > this.lugaresLivres)
            throw new PassengerCapacityExceeded();
        this.numPassageiros += numPassageiros;
        this.lugaresLivres -= numPassageiros;
    }


    public void removePassageiros(int numPassageiros) {
        this.numPassageiros -= numPassageiros;
        this.lugaresLivres += numPassageiros;
    }

    public void removePassageiros() {
        this.numPassageiros = 0;
        this.lugaresLivres = numPassageiros;
    }

    @Override
    public String toString() {
        return "Comboio " + nome + ", " + getNumCarruagens() + " carruagens, " + this.getNumLugares() + " lugares, " + numPassageiros + " passageiros";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Comboio comboio = (Comboio) object;
        return Objects.equals(carruagens, comboio.carruagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carruagens, numPassageiros);
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public String getDescricaoServico() {
        return this.servicoABordo.getDescricaoServico();
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }
}
