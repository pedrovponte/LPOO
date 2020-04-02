package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return this.getProduct().getPrice() * this.getQuantity();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return this.getProduct().getName() + "(x" + this.getQuantity() + "): " + (this.product.getPrice() * this.quantity) + "\n";
    }
}
