package com.aor.refactoring.example3;

public class FixedDiscount extends Discount {
    private final double fixed;

    public FixedDiscount(double fixed) {
        this.fixed = fixed;
    }

    public double getFixed() {
        return fixed;
    }

    @Override
    public double applyDiscount(double price) {
        return price - this.getFixed();
    }
}
