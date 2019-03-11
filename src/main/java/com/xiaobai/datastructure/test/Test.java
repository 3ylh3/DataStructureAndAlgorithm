package com.xiaobai.datastructure.test;

import com.xiaobai.datastructure.redandblacktree.RedAndBlackTree;

public class Test {
    public static void main(String[] args) {
        //红黑树测试
        RedAndBlackTree<Integer> tree = new RedAndBlackTree<Integer>();
        tree.put(318);
        tree.put(2);
        tree.put(749);
        tree.put(740);
        tree.put(786);
        tree.put(67);
        tree.put(502);
        tree.put(759);
        tree.put(461);
        tree.put(149);
        tree.printTree(tree);
    }
}
