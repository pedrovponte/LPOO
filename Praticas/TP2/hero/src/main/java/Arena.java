import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;


    public Arena(int height, int width, Hero hero) {
        this.height = height;
        this.width = width;
        this.hero = hero;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void retrieveCoins(){
        Coin toRemove = null;

        for(Coin coin : coins)
            if(coin.getPosition().equals(hero.getPosition())) {
                toRemove = coin;
                break;
            }
        if(toRemove != null)
            coins.remove(toRemove);
    }

    public void moveMonsters(){
        for(Monster monster : monsters)
            monster.setPosition(monster.move());
    }

    public boolean verifyMonsterCollisions(){
        for(Monster monster : monsters)
            if(monster.getPosition().equals(hero.getPosition())){
                return true;
            }
        return false;
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls)
            if (position.equals(wall.getPosition()))
                return false;
        return position.getX() <= width && position.getY() <= height;
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
        moveMonsters();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#DEB887"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

        for (Coin coin : coins)
            coin.draw(graphics);

        for (Monster monster : monsters)
            monster.draw(graphics);


        hero.draw(graphics);
    }
}
