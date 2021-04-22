package com.g35.data;

import java.util.Arrays;
import java.util.List;

public interface BlockComposite {
    List<Color> colorList = Arrays.asList(new Color("#01DF01"), new Color("#DF0101"), new Color("#0080FF"), new Color("#D6DF01"), new Color("#C001DF"), new Color("#FF8C00"), new Color("#8B4513"), new Color("#FFFFFF"));
    Color getColor();
    void randomColor();
    void changeColor(Color color);
    boolean colorIn(Color color);
    void notifyHeroChange(Position position);
    void notifyEnemyChange(Position position);
}
