import java.util.List;

public class StringTransformerGroup implements StringTransformer {

    List<StringTransformer> transformerList;

    public StringTransformerGroup(List<StringTransformer> transformerList) {
        this.transformerList = transformerList;
    }

    @Override
    public void execute() {
        for(StringTransformer s : transformerList)
            s.execute();
    }
}
