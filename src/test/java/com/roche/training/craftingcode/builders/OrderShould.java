package com.roche.training.craftingcode.builders;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderShould {

    @Test
    public void calculate_total_order_price_as_sum_of_all_order_items_total_prices() {

        Item item1 = mock(Item.class);
        when(item1.total()).thenReturn(100D);

        Item item2 = mock(Item.class);
        when(item2.total()).thenReturn(200D);

        Order order = new Order.Builder()
                .withItem(item1)
                .withItem(item2)
                .build();


        double itemTotalPricesSum = item1.total() + item2.total();

        assertEquals(itemTotalPricesSum, order.total(), 0);

    }

    @Test
    public void return_zero_on_empty_order() {
        Order order = new Order.Builder().build();
        assertEquals(0, order.total(), 0);
    }
}
