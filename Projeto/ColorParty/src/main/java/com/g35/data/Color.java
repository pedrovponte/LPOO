package com.g35.data;

import com.googlecode.lanterna.TextColor;

public class Color {
    private String colorCode;

    public Color(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getCode() {
        return colorCode;
    }

    public TextColor showColor() {
        return TextColor.Factory.fromString(colorCode);
    }

    public boolean sameColor(Color color) {
        return this.getCode().equals(color.getCode());
    }
}
