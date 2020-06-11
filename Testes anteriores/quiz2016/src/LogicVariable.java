public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy;

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.calculatedBy = null;
    }

    public LogicVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if(calculatedBy != null) calculatedBy.calculation();
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean equals(Object object) {
        LogicVariable logicVariable = (LogicVariable) object;

        return getName().equals(logicVariable.getName());
    }

    public LogicGate getCalculatedBy() {
        return this.calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }

    public String getFormula() {
        String res;
        if(calculatedBy == null) return name;

        res = calculatedBy.getSymbol() + "(";
        for(LogicVariable logicVariable : calculatedBy.getInputs()) {
            res += logicVariable.getFormula() + ",";
        }
        res = res.substring(0, res.length() - 1);
        res += ")";

        return res;
    }
}
