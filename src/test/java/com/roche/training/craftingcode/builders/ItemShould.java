package com.roche.training.craftingcode.builders;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemShould {
    @Test
    public void calculate_total_item_price_as_quantity_times_product_price() {

        Product product = mock(Product.class);
        when(product.price()).thenReturn(100D);

        int quantity = 2;
        Item item = new Item.Builder()
                .withProduct(product)
                .withQuantity(quantity)
                .build();

        double productsPriceTotal = product.price() * quantity;
        assertEquals(productsPriceTotal, item.total(), 0);
    }
}
