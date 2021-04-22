package com.g35.rules;

import com.g35.data.ArenaModel;
import com.g35.data.BlockModel;
import com.g35.data.EnemyModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;

import java.util.List;

public abstract class EnemyController {
    private List<EnemyModel> enemies;

    public EnemyController(List<EnemyModel> enemies) {
        this.enemies = enemies;
    }

    public abstract void moveEnemy(ArenaView gui, ArenaModel arena, EnemyModel enemy);

    public boolean checkLimitsCollision(Position position, List<BlockModel> limits) {
        for (BlockModel limit : limits) {
            if (limit.getPosition().samePosition(position))
                return true;
        }
        return false;
    }

    public boolean checkEnemiesCollision(Position position, ArenaModel arena) {
        int number_enemies = 0;     // Cada Enemy tem a mesma posição que ele próprio
        for (EnemyModel enemy : arena.getEnemies()) {
            if (enemy.getPosition().samePosition(position))
                number_enemies++;
        }
        return number_enemies > 1;
    }
}
