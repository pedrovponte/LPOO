public class GateNot extends LogicGate {
    private String symbol;

    public GateNot(LogicVariable output, LogicVariable input1) throws ColisionException, CycleException {
        super(output, input1);
        this.symbol = "NOT";
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void calculation() {
        LogicVariable in1 = getInputs()[0];

        setOutputValue(!in1.getValue());
    }
}
