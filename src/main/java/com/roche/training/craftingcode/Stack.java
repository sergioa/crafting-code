package com.roche.training.craftingcode;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack {

    private LinkedList<Object> linkedList = new LinkedList<Object>();

    public Object pop() throws StackException {
        try {
            return linkedList.pop();
        } catch (NoSuchElementException e) {
            throw new StackException();
        }
    }

    public void push(Object object) {
        linkedList.push(object);
    }


}
