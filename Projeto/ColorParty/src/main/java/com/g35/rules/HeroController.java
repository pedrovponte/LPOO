package com.g35.rules;

import com.g35.data.BlockModel;
import com.g35.data.EnemyModel;
import com.g35.data.HeroModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;

import java.util.List;

public class HeroController {
    private HeroModel hero;

    public HeroController(HeroModel hero) {
        this.hero = hero;
    }

    public boolean moveHero(ArenaView gui, ArenaController.COMMAND command) {
        Position newPosition = new Position(hero.getPosition());
        switch(command) {
            case UP:
                newPosition = newPosition.up(); break;
            case RIGHT:
                newPosition = newPosition.right(); break;
            case DOWN:
                newPosition = newPosition.down(); break;
            case LEFT:
                newPosition = newPosition.left(); break;
        }
        if (!checkLimitsCollision(newPosition, gui.limits)) {
            hero.setPosition(newPosition);
            return true;
        }
        return false;
    }

    public boolean checkLimitsCollision(Position position, List<BlockModel> limits) {
        for (BlockModel limit : limits) {
            if (limit.getPosition().samePosition(position))
                return true;
        }
        return false;
    }

    public boolean checkEnemyCollision(EnemyModel enemy) {
        // Check Collisions with Position above hero
        if (enemy.getPosition().samePosition(hero.getPosition().up()))
            return true;

        // Check Collisions with Position below hero
        else if (enemy.getPosition().samePosition(hero.getPosition().down()))
            return true;

        // Check Collisions with Positions next to hero
        else if (enemy.getPosition().samePosition(hero.getPosition().right()))
            return true;
        else if (enemy.getPosition().samePosition(hero.getPosition().left()))
            return true;

        return enemy.getPosition().samePosition(hero.getPosition());
    }
}
