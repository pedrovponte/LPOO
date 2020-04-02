package com.aor.refactoring.example3;

public class PercentageDiscount extends Discount {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - price * this.getPercentage();
    }
}
