public class StringInverter implements StringTransformer {

    private StringDrink stringDrink;

    public StringInverter(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    @Override
    public void execute() {
        StringBuffer sb = new StringBuffer(stringDrink.getText());
        sb.reverse();
        stringDrink.setText(sb.toString());
    }
}
