public class GateAnd extends LogicGate {
    private String symbol;

    public GateAnd(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
        super(output, input1, input2);
        this.symbol = "AND";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void calculation() {
        LogicVariable in1 = getInputs()[0];
        LogicVariable in2 = getInputs()[1];
        setOutputValue(in1.getValue() && in2.getValue());
    }
}
