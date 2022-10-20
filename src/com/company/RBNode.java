package com.company;

public class RBNode<E> extends Node<E> {
    private Color color;
    private RBNode<E> parent;
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

    public RBNode<E> getParent() {
        return parent;
    }

    public void setParent(RBNode<E> parent) {
        this.parent = parent;
    }

    public enum Color {
        RED, BLACK
    }
}
