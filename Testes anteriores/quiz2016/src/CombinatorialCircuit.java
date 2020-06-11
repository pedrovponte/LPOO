import java.util.HashSet;
import java.util.Set;

public class CombinatorialCircuit {
    private Set<LogicVariable> variables;

    public CombinatorialCircuit() {
        this.variables = new HashSet<>();
    }

    public boolean addVariable(LogicVariable logicVariable) {
        for(LogicVariable logicVariable1 : variables) {
            if(logicVariable1.equals(logicVariable))
                return false;
        }
        return this.variables.add(logicVariable);
    }

    public LogicVariable getVariableByName(String name) {
        for(LogicVariable logicVariable : variables) {
            if(logicVariable.getName().equals(name))
                return logicVariable;
        }
        return null;
    }
}
