package com.company;

public class BinarySearchTree {
    private Node<Integer> root;

    public Node<Integer> search(int value) {
        return this.search(this.root, value);
    }

    private Node<Integer> search(Node<Integer> node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
        }
        if (node.getValue() < value) {
            return search(node.getRight(), value);
        }
        return search(node.getLeft(), value);
    }

    public void insert(int value) {
        this.root = this.insert(this.root, value);
    }

    private Node<Integer> insert(Node<Integer> node, int value) {
        if (node == null) {
            node = new Node<>(value);
            return node;
        }
        if (value < node.getValue())
            node.setLeft(insert(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(insert(node.getRight(), value));

        return node;
    }

    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    private Node<Integer> delete(Node<Integer> node, int value) {
        if (node == null) return null;
        if (value < node.getValue())
            node.setLeft(delete(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(delete(node.getRight(), value));

        else {
            if (node.getLeft() == null)
                return node.getRight();
            else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setValue(minValue(node.getRight()));
            node.setRight(delete(node.getRight(), node.getValue()));
        }
        return node;
    }

    private int minValue(Node<Integer> node) {
        int min = node.getValue();
        while (node.getLeft() != null) {
            min = node.getLeft().getValue();
            node = node.getLeft();
        }
        return min;
    }

//    // This method mainly calls InorderRec()
//    public void inorder() {
//        inorderRec(this.root);
//    }
//
//    // A utility function to do inorder traversal of BST
//    private void inorderRec(Node<Integer> node) {
//        if (node != null) {
//            inorderRec(node.getLeft());
//            System.out.print(node.getValue() + " ");
//            inorderRec(node.getLeft());
//        }
//    }
    public InorderIterator<Node<Integer>> inorderIterator(){
        return new InorderIterator<>(this);
    }
    public Node<Integer> getRoot() {
        return root;
    }
    public void setRoot(Node<Integer> root) {
        this.root = root;
    }
}
