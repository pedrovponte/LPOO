package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.LineEnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;

import java.util.List;
import java.util.Random;

public class LineEnemyController extends EnemyController {

    public LineEnemyController(List<EnemyModel> enemies) {
        super(enemies);
    }

    @Override
    public void moveEnemy(ArenaView gui, ArenaModel arena, EnemyModel enemy) {
        Position newPosition = new Position(enemy.getPosition());

        if (((LineEnemyModel) enemy).getMovement() <= 0) {
            Random random = new Random();
            ((LineEnemyModel) enemy).setDirection(random.nextInt(4));
            ((LineEnemyModel) enemy).setMovement(5);
        }
        else {
            ((LineEnemyModel) enemy).setMovement(((LineEnemyModel) enemy).getMovement() - 1);
        }

        switch (((LineEnemyModel) enemy).getDirection()) {
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
