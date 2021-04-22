package com.g35.data;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class TestArenaModel {
    @Test
    public void testGetHero() {
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        HeroModel heroModel = arenaModel.getHero();
        assertTrue(heroModel.getPosition(). getX() > 0);
        assertTrue(heroModel.getPosition().getY() > 0);
        assertTrue(heroModel.getPosition().getX() < arenaModel.getWidth());
        assertTrue(heroModel.getPosition().getY() < arenaModel.getHeight());
    }

    @Test
    public void testGetEnemies() {
        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        List<EnemyModel> enemies = arenaModel.getEnemies();
        Mockito.when(arenaModel.getEnemies()).thenReturn(enemies);
        Mockito.verify(arenaModel, Mockito.times(1)).getEnemies();
    }

    @Test
    public void testGetHeight() {
        ArenaModel arena = new ArenaModel(100, 50, 1);

        assertEquals(50, arena.getHeight());
        assertTrue(arena.getHeight() > 0);
    }

    @Test
    public void testGetWidth() {
        ArenaModel arena = new ArenaModel(100, 50, 1);

        assertEquals(100, arena.getWidth());
    }

    @Test
    public void testGetHeroPosition() {
        ArenaModel arena = new ArenaModel(100, 50, 1);
        HeroModel hero = arena.getHero();
        hero.setPosition(new Position(45, 25));

        Position pos = new Position(45, 25);

        assertTrue(pos.samePosition(arena.getHeroPosition()));
    }

    @Test
    public void testHeroSetPosition() {
        ArenaModel arena = new ArenaModel(100, 50, 1);
        HeroModel hero = arena.getHero();
        hero.setPosition(new Position(45, 21));

        assertEquals(45, hero.getPosition().getX());
        assertEquals(21, hero.getPosition().getY());
    }

    @Test
    public void testCreateEnemies() {
        ArenaModel arenaModel  = new ArenaModel(102, 49, 1);
        List<EnemyModel> enemies = arenaModel.getEnemies();
        assertTrue(!enemies.isEmpty());
        for(int i = 0; i < enemies.size(); i++) {
            assertTrue(enemies.get(i).getPosition().getX() > 0);
            assertTrue(enemies.get(i).getPosition().getY() > 0);
            assertTrue(enemies.get(i).getPosition().getX() < arenaModel.getWidth());
            assertTrue(enemies.get(i).getPosition().getY() < arenaModel.getHeight());
        }
    }

    @Test
    public void testGetLineEnemies() {
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        ArenaModel arenaModel1 = new ArenaModel(102, 49, 2);
        ArenaModel arenaModel2 = new ArenaModel(102, 49, 3);
        assertEquals(4, arenaModel.getLineEnemies().size());
        for(int i = 0; i < arenaModel.getLineEnemies().size(); i++) {
            assertThat(arenaModel.getLineEnemies().get(i), instanceOf(LineEnemyModel.class));
        }
        for(int i = 0; i < arenaModel.getLineEnemies().size(); i++) {
            assertTrue((arenaModel.getLineEnemies().get(i).getPosition().getX() >= 2 && arenaModel.getLineEnemies().get(i).getPosition().getX() < 37) || (arenaModel.getLineEnemies().get(i).getPosition().getX() >= 60 && arenaModel.getLineEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel.getLineEnemies().get(i).getPosition().getY() >= 6 && arenaModel.getLineEnemies().get(i).getPosition().getY() < 45);
        }
        assertEquals(8, arenaModel1.getLineEnemies().size());
        for(int i = 0; i < arenaModel1.getLineEnemies().size(); i++) {
            assertThat(arenaModel1.getLineEnemies().get(i), instanceOf(LineEnemyModel.class));
        }
        for(int i = 0; i < arenaModel1.getLineEnemies().size(); i++) {
            assertTrue((arenaModel1.getLineEnemies().get(i).getPosition().getX() >= 2 && arenaModel1.getLineEnemies().get(i).getPosition().getX() < 37) || (arenaModel1.getLineEnemies().get(i).getPosition().getX() >= 60 && arenaModel1.getLineEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel1.getLineEnemies().get(i).getPosition().getY() >= 6 && arenaModel1.getLineEnemies().get(i).getPosition().getY() < 45);
        }
        assertEquals(12, arenaModel2.getLineEnemies().size());
        for(int i = 0; i < arenaModel2.getLineEnemies().size(); i++) {
            assertThat(arenaModel2.getLineEnemies().get(i), instanceOf(LineEnemyModel.class));
        }
        for(int i = 0; i < arenaModel2.getLineEnemies().size(); i++) {
            assertTrue((arenaModel2.getLineEnemies().get(i).getPosition().getX() >= 2 && arenaModel2.getLineEnemies().get(i).getPosition().getX() < 37) || (arenaModel2.getLineEnemies().get(i).getPosition().getX() >= 60 && arenaModel2.getLineEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel2.getLineEnemies().get(i).getPosition().getY() >= 6 && arenaModel2.getLineEnemies().get(i).getPosition().getY() < 45);
        }
    }

    @Test
    public void testGetFollowEnemies() {
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        ArenaModel arenaModel1 = new ArenaModel(102, 49, 2);
        ArenaModel arenaModel2 = new ArenaModel(102, 49, 3);

        assertEquals(4, arenaModel.getFollowEnemies().size());
        for(int i = 0; i < arenaModel.getFollowEnemies().size(); i++) {
            assertThat(arenaModel.getFollowEnemies().get(i), instanceOf(FollowEnemyModel.class));
        }
        assertEquals(6, arenaModel1.getFollowEnemies().size());
        for(int i = 0; i < arenaModel1.getFollowEnemies().size(); i++) {
            assertThat(arenaModel1.getFollowEnemies().get(i), instanceOf(FollowEnemyModel.class));
        }
        assertEquals(8, arenaModel2.getFollowEnemies().size());
        for(int i = 0; i < arenaModel2.getFollowEnemies().size(); i++) {
            assertThat(arenaModel2.getFollowEnemies().get(i), instanceOf(FollowEnemyModel.class));
        }
    }

    @Test
    public void testGetRandomEnemies() {
        ArenaModel arenaModel = new ArenaModel(102, 49, 1);
        ArenaModel arenaModel1 = new ArenaModel(102, 49, 2);
        ArenaModel arenaModel2 = new ArenaModel(102, 49, 3);

        assertEquals(4, arenaModel.getRandomEnemies().size());
        for(int i = 0; i < arenaModel.getRandomEnemies().size(); i++) {
            assertThat(arenaModel.getRandomEnemies().get(i), instanceOf(RandomEnemyModel.class));
        }
        for(int i = 0; i < arenaModel.getRandomEnemies().size(); i++) {
            assertTrue((arenaModel.getRandomEnemies().get(i).getPosition().getX() >= 2 && arenaModel.getRandomEnemies().get(i).getPosition().getX() < 37) || (arenaModel.getRandomEnemies().get(i).getPosition().getX() >= 60 && arenaModel.getRandomEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel.getRandomEnemies().get(i).getPosition().getY() >= 6 && arenaModel.getRandomEnemies().get(i).getPosition().getY() < 45);
        }
        assertEquals(4, arenaModel1.getRandomEnemies().size());
        for(int i = 0; i < arenaModel1.getRandomEnemies().size(); i++) {
            assertThat(arenaModel1.getRandomEnemies().get(i), instanceOf(RandomEnemyModel.class));
        }
        for(int i = 0; i < arenaModel1.getRandomEnemies().size(); i++) {
            assertTrue((arenaModel1.getRandomEnemies().get(i).getPosition().getX() >= 2 && arenaModel1.getRandomEnemies().get(i).getPosition().getX() < 37) || (arenaModel1.getRandomEnemies().get(i).getPosition().getX() >= 60 && arenaModel1.getRandomEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel1.getRandomEnemies().get(i).getPosition().getY() >= 6 && arenaModel1.getRandomEnemies().get(i).getPosition().getY() < 45);
        }
        assertEquals(4, arenaModel2.getRandomEnemies().size());
        for(int i = 0; i < arenaModel2.getRandomEnemies().size(); i++) {
            assertThat(arenaModel2.getRandomEnemies().get(i), instanceOf(RandomEnemyModel.class));
        }
        for(int i = 0; i < arenaModel2.getRandomEnemies().size(); i++) {
            assertTrue((arenaModel2.getRandomEnemies().get(i).getPosition().getX() >= 2 && arenaModel2.getRandomEnemies().get(i).getPosition().getX() < 37) || (arenaModel2.getRandomEnemies().get(i).getPosition().getX() >= 60 && arenaModel2.getRandomEnemies().get(i).getPosition().getX() < 90));
            assertTrue(arenaModel2.getRandomEnemies().get(i).getPosition().getY() >= 6 && arenaModel2.getRandomEnemies().get(i).getPosition().getY() < 45);
        }
    }
}
