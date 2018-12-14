package com.roche.training.craftingcode.builders;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Item> items = new ArrayList<>();

    private Order(Builder builder) {
        builder.items.forEach(items::add);
    }

    public double total() {
        return items.stream().mapToDouble(Item::total).sum();
    }

    public static class Builder {
        List<Item> items = new ArrayList<>();

        public Builder withItem(Item item) {
            items.add(item);
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }
}
