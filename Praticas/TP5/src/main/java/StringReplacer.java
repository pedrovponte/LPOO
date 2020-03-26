public class StringReplacer implements StringTransformer {

    private StringDrink stringDrink;
    private char oldChar;
    private char newChar;

    public StringReplacer(StringDrink stringDrink, char oldChar, char newChar) {
        this.stringDrink = stringDrink;
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public void execute() {
        char[] chars = stringDrink.getText().toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(chars[i] == oldChar)
                chars[i] = newChar;
        }

        stringDrink.setText(new String(chars));
    }
}
