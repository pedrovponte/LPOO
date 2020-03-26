import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {

    private List<StringRecipe> recipes;

    SmartStrategy() {
        this.recipes = new ArrayList<>();
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour())
            bar.order(recipe);
        else
            recipes.add(recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(StringRecipe recipe : recipes)
            bar.order(recipe);
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
