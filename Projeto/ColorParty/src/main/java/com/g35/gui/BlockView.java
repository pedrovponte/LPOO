package com.g35.gui;

import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g35.data.BlockModel;
import com.g35.data.Position;
import com.g35.observer.Observer;

public class BlockView implements Observer<BlockModel> {
    static TextGraphics graphics;

    public BlockView(TextGraphics graphics) {
        BlockView.graphics = graphics;
    }

    @Override
    public void changed(BlockModel subject) {
        draw(subject);
    }

    public void draw(BlockModel block) {
        if (block.getColor() != null) {
            graphics.setBackgroundColor(block.getColor().showColor()); // MUDAR COR DOS LIMITES MAIS TARDE
            graphics.setForegroundColor(block.getColor().showColor());
        }
        else {
            block.randomColor();
        }
        Position blockPosition = block.getPosition();
        graphics.putString(new TerminalPosition(blockPosition.getX(), blockPosition.getY()), String.valueOf(Symbols.BLOCK_SOLID));
    }
}
