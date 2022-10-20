package com.company.uml;

import com.company.BinarySearchTree;
import com.company.Node;
import com.company.RBNode;

public class RBtree extends BinarySearchTree {
    private RBNode<Integer> root;

    private Node<Integer> search(Node<Integer> node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
        }
        if (node.getValue() < value) {
            return search(node.getRight(), value);
        }
        return search(node.getLeft(), value);
    }

    // this function performs left rotation
    RBNode<Integer> rotateLeft(RBNode<Integer> node)
    {
        RBNode<Integer> x = (RBNode<Integer>) node.getRight();
        RBNode<Integer> y = (RBNode<Integer>) x.getLeft();
        x.setLeft(node);
        node.setRight(y);
        node.setParent(x); // parent resetting is also important.
        if(y!=null)
            y.setParent(node);
        return x;
    }
    //this function performs right rotation
    RBNode<Integer> rotateRight(RBNode<Integer> node)
    {
        RBNode<Integer> x = (RBNode<Integer>) node.getLeft();
        RBNode<Integer> y = (RBNode<Integer>) x.getRight();
        x.setRight(node);
        node.setLeft(y);
        node.setParent(x);
        if(y!=null)
            y.setParent(node);
        return x;
    }
}
