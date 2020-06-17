public class Pendular extends Comboio {
    private ServicoABordo servicoABordo;
    public Pendular(String nome) {
        super(nome);
        this.servicoABordo = new ServicoSemEnjoos();
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
