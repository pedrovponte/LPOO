public class StringCaseChanger implements StringTransformer {

    private StringDrink stringDrink;

    public StringCaseChanger(StringDrink stringDrink) {
        this.stringDrink = stringDrink;
    }

    @Override
    public void execute() {
        char[] chars = stringDrink.getText().toCharArray();

        for(int i = 0; i < chars.length; i++){
            if(Character.isLowerCase(chars[i]))
                chars[i] = Character.toUpperCase(chars[i]);
            else
                chars[i] = Character.toLowerCase(chars[i]);
        }

        stringDrink.setText(new String(chars));
    }
}
