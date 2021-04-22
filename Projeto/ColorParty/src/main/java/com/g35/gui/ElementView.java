package com.g35.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g35.data.ElementModel;
import com.g35.data.EnemyModel;
import com.g35.data.HeroModel;
import com.g35.data.Position;
import com.g35.observer.Observer;

public class ElementView implements Observer<ElementModel> {
    protected TextGraphics graphics;

    public ElementView(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void changed(ElementModel subject) {
        draw(subject);
    }

    public void draw(ElementModel elementModel) {
        if(elementModel instanceof EnemyModel) {
            Position elementModelPosition = elementModel.getPosition();
            graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(elementModelPosition.getX(), elementModelPosition.getY()), "E");
        }

        if(elementModel instanceof HeroModel) {
            Position elementModelPosition = elementModel.getPosition();
            graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
            graphics.enableModifiers(SGR.BOLD);
            graphics.putString(new TerminalPosition(elementModelPosition.getX(), elementModelPosition.getY()), "H");
        }
    }
}
