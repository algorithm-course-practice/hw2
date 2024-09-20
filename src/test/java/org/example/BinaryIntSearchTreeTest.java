package org.example;

import org.junit.jupiter.api.Test;

class BinaryIntSearchTreeTest {

    @Test
    public void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
    }
}