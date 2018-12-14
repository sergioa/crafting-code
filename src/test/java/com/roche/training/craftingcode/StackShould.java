package com.roche.training.craftingcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StackShould {

    private Object firstElement = new Object();
    private Object lastElement = new Object();

    @Test(expected = StackException.class)
    public void fail_when_pop_on_empty_stack() throws StackException {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test
    public void retrieve_the_last_pushed_element_when_pop() throws StackException {
        Stack stack = new Stack();
        stack.push(firstElement);
        stack.push(lastElement);
        assertEquals(stack.pop(), lastElement);
    }

    @Test
    public void retrieve_elements_in_reverse_order_as_they_were_pushed() throws StackException {
        Stack stack = new Stack();
        stack.push(firstElement);
        stack.push(lastElement);
        assertEquals(stack.pop(), lastElement);
        assertEquals(stack.pop(), firstElement);
    }


}
