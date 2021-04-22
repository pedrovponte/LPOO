package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;

import java.util.List;
import java.util.Random;

public class RandomEnemyController extends EnemyController {

    public RandomEnemyController(List<EnemyModel> enemies) {
        super(enemies);
    }

    @Override
    public void moveEnemy(ArenaView gui, ArenaModel arena, EnemyModel enemy) {
        Position newPosition = new Position(enemy.getPosition());

        Random random = new Random();
        int direction = random.nextInt(4);

        switch (direction) {
            case 0:
                newPosition = newPosition.up();
                break;
            case 1:
                newPosition = newPosition.down();
                break;
            case 2:
                newPosition = newPosition.left();
                break;
            case 3:
                newPosition = newPosition.right();
                break;
        }

        if (!checkLimitsCollision(newPosition, gui.limits) && !checkEnemiesCollision(newPosition, arena)) {
            enemy.setPosition(newPosition);
        }
    }
}

