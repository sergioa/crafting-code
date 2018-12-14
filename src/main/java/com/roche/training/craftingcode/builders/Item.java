package com.roche.training.craftingcode.builders;

public class Item {

    private int quantity;
    private Product product;

    private Item(Builder builder) {
        this.quantity = builder.quantity;
        this.product = builder.product;
    }

    public double total() {
        return quantity * product.price();
    }

    public static class Builder {
        private int quantity;
        private Product product;

        public Builder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

}
