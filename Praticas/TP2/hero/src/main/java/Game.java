import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Terminal terminal;
    private Screen screen;
    private int x = 10;
    private int y = 10;
    Arena arena;
    TextGraphics graphics;

    Game(){
        try {
            int width = 80;
            int height = 24;

            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            graphics = screen.newTextGraphics();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');

            arena = new Arena(height, width, new Hero(x,y));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void draw() throws IOException{
        screen.clear();
        arena.verifyMonsterCollisions();
        arena.moveMonsters();
        arena.retrieveCoins();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();
            else if (key.getKeyType() == KeyType.EOF)
                break;
            else
                processKey(key);
        }
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

}
