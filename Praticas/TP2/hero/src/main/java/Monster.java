import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster  extends Element{

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move(){
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0:
                return new Position(position.getX() + 1, position.getY());
            case 1:
                return new Position(position.getX() - 1, position.getY());
            case 3:
                return new Position(position.getX(), position.getY() + 1);
            case 4:
                return new Position(position.getX(), position.getY() - 1);
        }
        return new Position(position.getX(), position.getY());
    }
}
