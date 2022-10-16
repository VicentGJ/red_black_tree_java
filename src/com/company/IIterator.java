//adapted from lib

package com.company;

import java.util.Iterator;

public interface IIterator<E> extends Iterator<E> {
    Node<E> nextNode();
}
