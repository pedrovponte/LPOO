package com.g35.rules;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.ArenaModel;
import com.g35.data.EnemyModel;
import com.g35.data.HeroModel;
import com.g35.data.Position;
import com.g35.gui.ArenaView;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class TestHeroController {
    @Test
    public void testMoveHero() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        HeroModel hero = arenaModel.getHero();
        hero.setPosition(new Position(20, 20));
        HeroController heroController = new HeroController(hero);

        assertTrue(heroController.moveHero(arenaView, ArenaController.COMMAND.UP));
        assertEquals(new Position(20, 19).getX(), hero.getPosition().getX());
        assertEquals(new Position(20, 19).getY(), hero.getPosition().getY());
        assertTrue(heroController.moveHero(arenaView, ArenaController.COMMAND.DOWN));
        assertEquals(new Position(20, 20).getX(), hero.getPosition().getX());
        assertEquals(new Position(20, 20).getY(), hero.getPosition().getY());
        assertTrue(heroController.moveHero(arenaView, ArenaController.COMMAND.LEFT));
        assertEquals(new Position(19, 20).getX(), hero.getPosition().getX());
        assertEquals(new Position(19, 20).getY(), hero.getPosition().getY());
        assertTrue(heroController.moveHero(arenaView, ArenaController.COMMAND.RIGHT));
        assertEquals(new Position(20, 20).getX(), hero.getPosition().getX());
        assertEquals(new Position(20, 20).getY(), hero.getPosition().getY());

        // Caso de Colisões
        hero.setPosition(new Position(100, 26));
        assertFalse(heroController.moveHero(arenaView, ArenaController.COMMAND.RIGHT));
    }

    @Test
    public void TestCheckEnemyCollision() {
        HeroModel heroModel = new HeroModel(new Position(25, 24));
        HeroController heroController = new HeroController(heroModel);
        EnemyModel enemyModel = new EnemyModel(new Position(25, 24));

        assertTrue(heroController.checkEnemyCollision(enemyModel));

        enemyModel.setPosition(new Position(30, 27));
        assertFalse(heroController.checkEnemyCollision(enemyModel));

        enemyModel.setPosition(new Position(25, 23));
        assertTrue(heroController.checkEnemyCollision(enemyModel));

        enemyModel.setPosition(new Position(25, 25));
        assertTrue(heroController.checkEnemyCollision(enemyModel));

        enemyModel.setPosition(new Position(24, 24));
        assertTrue(heroController.checkEnemyCollision(enemyModel));

        enemyModel.setPosition(new Position(26, 24));
        assertTrue(heroController.checkEnemyCollision(enemyModel));
    }

    @Test
    public void TestCheckLimitsCollision() throws IOException {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        ArenaView arenaView = new ArenaView(102, 49, screen, graphics, 1);
        HeroModel heroModel = new HeroModel(new Position(25, 24));
        HeroController heroController = new HeroController(heroModel);

        assertFalse(heroController.checkLimitsCollision(heroModel.getPosition(), arenaView.limits));

        heroModel.setPosition(new Position(100, 26));
        assertTrue(heroController.checkLimitsCollision(heroModel.getPosition(), arenaView.limits));
    }
}
