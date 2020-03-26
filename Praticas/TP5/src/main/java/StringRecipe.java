import java.util.List;

public class StringRecipe  {
    List<StringTransformer> transformerList;

    public StringRecipe(List<StringTransformer> transformerList) {
        this.transformerList = transformerList;
    }

    public void mix(){
        for(StringTransformer s : transformerList)
            s.execute();
    }
}
