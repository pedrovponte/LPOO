package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.FollowEnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;


import java.util.List;

public class FollowEnemyController extends EnemyController {

    public FollowEnemyController(List<EnemyModel> enemies) {
        super(enemies);
    }

    @Override
    public void moveEnemy(ArenaView gui, ArenaModel arena, EnemyModel enemy) {
        Position newPosition = new Position(enemy.getPosition());
        Position heroPosition = ((FollowEnemyModel) enemy).getHeroPosition();
        if (Math.abs(heroPosition.getX() - newPosition.getX()) > Math.abs(heroPosition.getY() - newPosition.getY())) {
            if (heroPosition.getX() < newPosition.getX()) {
                newPosition = newPosition.left();
            }
            else {
                newPosition = newPosition.right();
            }
        }
        else {
            if (heroPosition.getY() > newPosition.getY()) {
                newPosition = newPosition.down();
            }
            else {
                newPosition = newPosition.up();
            }
        }

        if (!checkLimitsCollision(newPosition, gui.limits) && !checkEnemiesCollision(newPosition, arena)) {
            enemy.setPosition(newPosition);
        }
    }
}
