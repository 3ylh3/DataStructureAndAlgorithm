package com.xiaobai.datastructure.test;

import com.xiaobai.datastructure.redandblacktree.RedAndBlackTree;

public class Test {
    public static void main(String[] args) {
        //红黑树测试
        RedAndBlackTree<Integer> tree = new RedAndBlackTree<Integer>();
        tree.put(901);
        tree.put(805);
        tree.put(733);
        tree.put(397);
        tree.put(641);
        tree.put(854);
        tree.put(899);
        tree.put(600);
        tree.put(872);
        tree.put(478);
        tree.put(435);
        tree.put(764);
        tree.remove(641);
        tree.remove(764);
        tree.remove(899);
        tree.remove(733);
        tree.remove(872);
        tree.remove(901);
        tree.remove(854);
        tree.printTree(tree);
    }
}
