package com.company;
//adapted from lib
public class StackNode<E> {
    private Node<E> node;
    private int count;

    public StackNode(Node<E> node) {
        this.node = node;
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        ++this.count;
    }

    public Node<E> getRight() {
        return this.node.getRight();
    }

    public Node<E> getLeft() {
        return this.node.getLeft();
    }

    public Node<E> getNode() {
        return this.node;
    }
}
