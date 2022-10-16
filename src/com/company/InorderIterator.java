//adapted from lib
package com.company;

import java.util.ArrayDeque;

public class InorderIterator<E> implements IIterator<E> {
    private Node<E> nextNode;
    private Node<E> currentNode;
    private BinarySearchTree tree;
    private ArrayDeque<StackNode<E>> stack;

    public InorderIterator(BinarySearchTree tree) {
        this.tree = tree;
        this.stack = new ArrayDeque<>();
        this.currentNode = null;
        this.nextNode = this.moveCursorToLastLeftNode((Node<E>) tree.getRoot());
        this.tree = tree;
    }

    public Node<E> nextNode() {
        this.currentNode = this.nextNode;
        if (this.currentNode != null) {
            if (this.currentNode.getRight() != null) {
                StackNode<E> node = new StackNode<E>(this.currentNode);
                node.incrementCount();
                node.incrementCount();
                this.stack.push(node);
                this.nextNode = this.moveCursorToLastLeftNode(this.currentNode.getRight());
            } else {
                this.nextNode = null;
                if (!this.stack.isEmpty()) {
                    boolean foundedNextNode = false;

                    while (!this.stack.isEmpty() && !foundedNextNode) {
                        StackNode<E> father = this.stack.pop();
                        if (father.getCount() == 1) {
                            foundedNextNode = true;
                            this.nextNode = father.getNode();
                        }
                    }
                }
            }
        }

        return this.currentNode;
    }

    public boolean hasNext() {
        return this.nextNode != null;
    }

    public E next() {
        E currentInfo = null;
        Node<E> current = this.nextNode();
        if (current != null) {
            currentInfo = current.getValue();
        }

        return currentInfo;
    }

    public void remove() {
        this.tree.delete((Integer) this.currentNode.getValue());
    }

    private Node<E> moveCursorToLastLeftNode(Node<E> initialNode) {
        Node<E> cursor = null;
        if (initialNode != null) {
            for (cursor = initialNode; cursor.getLeft() != null; cursor = cursor.getLeft()) {
                StackNode<E> node = new StackNode<>(cursor);
                node.incrementCount();
                this.stack.push(node);
            }
        }

        return cursor;
    }
}
