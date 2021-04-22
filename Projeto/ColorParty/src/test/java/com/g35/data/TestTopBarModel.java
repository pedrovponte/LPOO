package com.g35.data;

import com.g35.gui.ArenaView;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TestTopBarModel {
    private Screen screen;
    private TextGraphics graphics;
    private TopBarModel topBarModel;

    @Before
    public void Preparations() throws IOException {
        /*Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(102, 49)).createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.graphics = screen.newTextGraphics();*/
        screen = mock(Screen.class);
        graphics = mock(TextGraphics.class);
        topBarModel = new TopBarModel(102, 49, new ArenaView(102, 49, screen, graphics, 1));
    }

    @Test
    public void testGetHeight() {
        assertEquals(49, topBarModel.getHeight());
    }

    @Test
    public void testGetWidth() {
        assertEquals(102, topBarModel.getWidth());
    }

    @Test
    public void testGetColor() {
        topBarModel.setColor(new Color("#FFFFFF"));
        assertEquals("#FFFFFF", topBarModel.getColor().getCode());
    }

    @Test
    public void testColorInArena() {
        topBarModel.setColor(new Color("#FFFFFF"));
        assertEquals(true, topBarModel.colorInArena(new Color("#FFFFFF")));
        assertEquals(false, topBarModel.colorInArena(new Color("000000")));
    }

}
