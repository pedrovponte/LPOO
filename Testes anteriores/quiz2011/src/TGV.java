public class TGV extends Comboio {
    private ServicoABordo servicoABordo;
    public TGV(String nome) {
        super(nome);
        this.servicoABordo = new ServicoPrioritario();
    }

    public String toString() {
        return "TGV " + getNome() + ", " + getNumCarruagens() + " carruagem, " + getNumLugares() + " lugar, " + getNumPassageiros() + " passageiros";
    }

    @Override
    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }

    public String getDescricaoServico() {
        return this.servicoABordo.getDescricaoServico();
    }
}
