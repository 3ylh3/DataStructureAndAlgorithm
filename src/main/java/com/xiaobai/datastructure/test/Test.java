package com.xiaobai.datastructure.test;

import com.xiaobai.datastructure.redandblacktree.RedAndBlackTree;
import com.xiaobai.datastructure.sort.Sort;

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
        int[] a = {10,2,8,7,9,3,4,1,6,5};
        //排序测试
        Sort sort = new Sort();
        //冒泡排序
        //sort.bubbleSort(a);
        //快速排序
        sort.quickSort(a,0,a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
