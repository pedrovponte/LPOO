package com.g35.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g35.data.*;
import org.junit.Before;
import org.junit.Test;
import com.g35.rules.ArenaController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestArenaView {
    private ArenaController.COMMAND command;
    private ArenaView arenaView1;
    private ArenaView arenaView2;
    private ArenaView arenaView3;
    private ArenaView arenaViewMock;
    private ArenaModel arenaModelMock;
    private Screen screenMock;

    @Before
    public void Preparations() {
        Screen screen = mock(Screen.class);
        TextGraphics graphics = mock(TextGraphics.class);
        command = ArenaController.COMMAND.RIGHT;
        arenaView1 = new ArenaView(102,49, screen, graphics, 1);
        arenaView2 = new ArenaView(102, 49, screen, graphics, 2);
        arenaView3 = new ArenaView(102, 49, screen, graphics, 3);
        arenaViewMock = mock(ArenaView.class);
        arenaModelMock = mock(ArenaModel.class);
        HeroModel heroModel = mock(HeroModel.class);
        EnemyModel enemyModel = mock(EnemyModel.class);
        when(arenaModelMock.getWidth()).thenReturn(102);
        when(arenaModelMock.getHeight()).thenReturn(49);
        when(arenaModelMock.getHero()).thenReturn(heroModel);
        List<EnemyModel> enemies = new ArrayList<>();
        enemies.add(enemyModel);
        when(arenaModelMock.getEnemies()).thenReturn(enemies);
        screenMock = mock(Screen.class);
        when(arenaViewMock.getScreen()).thenReturn(screenMock);
    }

    @Test
    public void TestSetGet() {
        // Test getScreen()
        arenaView1.setScreen(screenMock);
        assertEquals(screenMock, arenaView1.getScreen());

        // Test getHeroObserver()
        assertThat(arenaView1.getHeroObserver(), instanceOf(ElementView.class));

        // Test getEnemyObserver()
        assertThat(arenaView1.getEnemyObserver(), instanceOf(ElementView.class));

        // Test getTopBarView()
        assertThat(arenaView1.getTopBarView(), instanceOf(TopBarView.class));

        // Test getArenaBlock()
        assertThat(arenaView1.getArenaBlock(), instanceOf(BlockComposite.class));
    }

    @Test
    public void TestCommand() {
        assertEquals(ArenaController.COMMAND.RIGHT, command);
    }

    @Test
    public void TestChanged() {
        doCallRealMethod().when(arenaViewMock).changed(arenaModelMock);
        arenaViewMock.changed(arenaModelMock);
        verify(arenaViewMock, times(1)).drawArena();
    }

    @Test
    public void TestCloseScreen() throws IOException {
        arenaView1.setScreen(screenMock);
        arenaView1.closeScreen();
        verify(screenMock, times(1)).close();
    }

    @Test
    public void TestFindArenaBlock() {
        // Test for Easy Mode
        List<BlockModel> minimumBlocks = arenaView1.getMinimumBlocks();
        BlockModel block = minimumBlocks.get(0);
        block.setPosition(new Position(25, 50));

        assertEquals(block, arenaView1.findArenaBlock(new Position(25, 50)));

        // Test for Medium Mode
        List<BlockModel> minimumBlocks2 = arenaView2.getMinimumBlocks();
        BlockModel block2 = minimumBlocks2.get(0);
        block2.setPosition(new Position(25, 50));

        assertEquals(block2, arenaView2.findArenaBlock(new Position(25, 50)));

        // Test for Hard Mode
        List<BlockModel> minimumBlocks3 = arenaView3.getMinimumBlocks();
        BlockModel block3 = minimumBlocks3.get(0);
        block3.setPosition(new Position(25, 50));

        assertEquals(block3, arenaView3.findArenaBlock(new Position(25, 50)));
    }
}
