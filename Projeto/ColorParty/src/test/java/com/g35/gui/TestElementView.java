package com.g35.gui;

import com.g35.data.ElementModel;
import com.g35.data.EnemyModel;
import com.g35.data.HeroModel;
import com.g35.data.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TestElementView {
    ElementView view;
    TextGraphics graphicsMock;
    ElementModel enemyMock;
    ElementModel heroMock;

    @Before
    public void Preparations() {
        graphicsMock = Mockito.mock(TextGraphics.class);
        view = new ElementView(graphicsMock);

        enemyMock = Mockito.mock(EnemyModel.class);
        heroMock = Mockito.mock(HeroModel.class);

        when(enemyMock.getPosition()).thenReturn(new Position(25, 35));
        when(heroMock.getPosition()).thenReturn(new Position(50, 45));
    }

    @Test
    public void testChangedDraw() {
        view.changed(enemyMock);
        verify (graphicsMock, times(1)).putString(new TerminalPosition(25, 35), "E");
        view.changed(heroMock);
        verify (graphicsMock, times(1)).putString(new TerminalPosition(50, 45), "H");
    }
}
