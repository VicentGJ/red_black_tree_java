package com.company;

public class RBNode<E> extends Node<E> {
    private Color color;
    public RBNode(E value, Color color) {
        super(value);
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public enum Color {
        RED, BLACK
    }
}
