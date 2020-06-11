public abstract class LogicGate {
    private LogicVariable output;
    private LogicVariable[] inputs;

    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws ColisionException, CycleException {
        if(output.getCalculatedBy() != null) throw new ColisionException();
        if(input1.getCalculatedBy() != null) {
            if(input1.getCalculatedBy().inputContains(output))
                throw new CycleException();
        }
        if(input2.getCalculatedBy() != null) {
            if(input2.getCalculatedBy().inputContains(output))
                throw new CycleException();
        }
        this.output = output;
        this.inputs = new LogicVariable[]{input1, input2};
        this.output.setCalculatedBy(this);
    }

    public LogicGate(LogicVariable output, LogicVariable input1) throws ColisionException, CycleException {
        if(output.getCalculatedBy() != null) throw new ColisionException();
        if(input1.getCalculatedBy() != null) {
            if(input1.getCalculatedBy().inputContains(output))
                throw new CycleException();
        }
        this.output = output;
        this.inputs = new LogicVariable[]{input1};
        this.output.setCalculatedBy(this);
    }

    public LogicVariable getOutput() {
        return output;
    }

    public void setOutputValue(Boolean outputValue){
        this.output.setValue(outputValue);
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }

    public void setInputs(LogicVariable[] inputs) {
        this.inputs = inputs;
    }

    public abstract String getSymbol();

    public abstract void setSymbol(String symbol);

    public String getFormula() {
        return output.getFormula();
    }

    public abstract void calculation();

    public boolean inputContains(LogicVariable logicVariable) {
        for(LogicVariable logicVariable1 : inputs) {
            if(logicVariable1.equals(logicVariable))
                return true;
        }
        return false;
    }
}
