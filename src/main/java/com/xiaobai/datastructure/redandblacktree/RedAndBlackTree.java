package com.xiaobai.datastructure.redandblacktree;

import java.util.LinkedList;

/**
 * 红黑树
 * 红黑树是一种平衡德二叉查找树，它有以下特性：
 * 1.每个节点或者是红色，或者是黑色
 * 2.根节点是黑色
 * 3.每个叶子节点是黑色，这里的叶子节点是指为空的叶子节点
 * 4.如果一个节点是红的，那么它的子节点必须是黑的
 * 5.从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑色节点
 * @param <E> 树节点值类型
 */
public class RedAndBlackTree<E extends Comparable<E>> {
    /**
     * 红黑树节点
     */
    private class TreeNode {
        //父节点
        private TreeNode parent;
        //左孩子
        private TreeNode leftChild;
        //右孩子
        private TreeNode rightChild;
        //节点值
        private E value;
        //颜色
        private String color;

        /**
         * 无参构造函数，默认初始化颜色为红色
         */
        public TreeNode(){
            this.color = "red";
        }

        /**
         * 有参构造函数
         * 默认初始化颜色为红色
         * @param parent 父节点
         * @param leftChild 左孩子
         * @param rightChild 右孩子
         * @param value 节点值
         */
        public TreeNode(TreeNode parent,TreeNode leftChild,TreeNode rightChild,E value,String color){
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.value = value;
            this.color = color;
        }
    }
    //根节点
    private TreeNode root;

    /**
     * 无参构造函数
     */
    public RedAndBlackTree(){

    }

    /**
     * 左旋
     * @param node 需要进行左旋的节点
     */
    public void leftRotate(TreeNode node){
        //新建tmpNode节点，把node的右孩子赋给tmpNode
        TreeNode tmpNode = node.rightChild;
        if(tmpNode == null){
            return;
        }
        TreeNode lchild = tmpNode.leftChild;
        if(lchild != null){
            //将tmpNode的左孩子设为node的右孩子
            node.rightChild = lchild;
            //将tmpNode的左孩子的父亲设为node
            tmpNode.leftChild.parent = node;
        }
        else{
            //将node的右孩子设为空
            node.rightChild = null;
        }
        //将node的父亲设为tmpNode的父亲
        tmpNode.parent = node.parent;
        //判断如果node的父亲是空，则设tmpNode为root节点
        if(node.parent == null){
            this.root = tmpNode;
        }
        //如果node是它父亲的左孩子，那么将tmpNode设为node父亲的左孩子
        else if(node == (node.parent.leftChild)){
            node.parent.leftChild = tmpNode;
        }
        //否则将tmpNode设为node父亲的右孩子
        else{
            node.parent.rightChild = tmpNode;
        }
        //将node设为tmpNode的左孩子
        tmpNode.leftChild = node;
        //将node的父节点设为tmpNode
        node.parent = tmpNode;
    }

    /**
     * 右旋
     * @param node 需要右旋的节点
     */
    public void rightRotate(TreeNode node){
        //新建tmpNode节点，把node的左孩子赋给tmpNode
        TreeNode tmpNode = node.leftChild;
        if(tmpNode == null){
            return;
        }
        TreeNode rchild = tmpNode.rightChild;
        if(rchild != null) {
            //将tmpNode的右孩子设为node的左孩子
            node.leftChild = tmpNode.rightChild;
            //将tmpNode右孩子的父节点设为node
            tmpNode.rightChild.parent = node;
        }
        else{
            //将node的左孩子设为空
            node.leftChild = null;
        }
        //将node的父亲设为tmpNode的父亲
        tmpNode.parent = node.parent;
        //判断如果node的父亲是空，则设tmpNode为root节点
        if(node.parent == null){
            this.root = tmpNode;
        }
        //如果node是它父亲的左孩子，那么将tmpNode设为node父亲的左孩子
        else if(node == (node.parent.leftChild)){
            node.parent.leftChild = tmpNode;
        }
        //否则将tmpNode设为node父亲的右孩子
        else{
            node.parent.rightChild = tmpNode;
        }
        //将node设为tmpNode的右孩子
        tmpNode.rightChild = node;
        //将node的父节点设为tmpNode
        node.parent = tmpNode;
    }

    /**
     * 打印红黑树,根据层次遍历思想，使用两个队列
     * @param tree 需要打印的红黑树
     */
    public void printTree(RedAndBlackTree<E> tree){
        TreeNode root = tree.root;
        if(root == null){
            return;
        }
        //list1队列用作层次遍历用
        LinkedList<TreeNode> list1 = new LinkedList<TreeNode>();
        //list2队列用作最后打印用
        LinkedList<TreeNode> list2 = new LinkedList<TreeNode>();
        //将根节点入队列list1
        list1.addLast(root);
        //如果队列list1不为空，则继续循环
        while(list1.size() != 0){
            //list1出队列
            TreeNode node = list1.removeFirst();
            //将节点值存进list2队列
            list2.addLast(node);
            //将节点左右孩子分别入队列list1，如果为空则入节点值为*的
            if(node.leftChild != null){
                list1.addLast(node.leftChild);
            }
            else{
                TreeNode tmpNode = new TreeNode(null,null,null,(E)"*","black");
                list1.addLast(tmpNode);
            }
            if(node.rightChild != null){
                list1.addLast(node.rightChild);
            }
            else{
                TreeNode tmpNode = new TreeNode(null,null,null,(E)"*","black");
                list1.addLast(tmpNode);
            }
            //判断如果队列list1不为空且均为*,代表遍历完成，将list1中剩余节点值均入队列list2中
            boolean flag = true;
            if(list1.size() == 0){
                flag = false;
            }
            for(int num = 0;num < list1.size();num++){
                if(!list1.get(num).value.equals("*")){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                while(list1.size() != 0){
                    TreeNode tmp = list1.removeFirst();
                    list2.addLast(tmp);
                }
                break;
            }
        }
        //打印list2中最终结果，每打印2的n次方个数打印一个空格（n从0开始递增）
        int i = 1,j = 0;
        while(list2.size() != 0){
            TreeNode treeNode = list2.removeFirst();
            System.out.print(treeNode.value + ":" +treeNode.color  + " ");
            if(i == Math.pow(2,j)){
                System.out.println();
                i = 0;
                j++;
            }
            i++;
        }
    }

    /**
     * 插入新节点
     * @param value 要插入节点的值
     */
    public void put(E value){
        TreeNode node = new TreeNode(null,null,null,value,"red");
        TreeNode index = this.root;
        TreeNode parent = null;
        //寻找插入位置
        if(index == null){
            this.root = node;
        }
        else{
            while(index != null){
                parent = index;
                if(value.compareTo(index.value) < 0){
                    index = index.leftChild;
                }
                else if(value.compareTo(index.value) > 0){
                    index = index.rightChild;
                }
                else{
                    return;
                }
            }
            //将node的parent设为parent
            node.parent = parent;
            //如果value小于parent的节点值，则将node置为parent的左孩子，否则置为右孩子
            if(value.compareTo(parent.value) < 0){
                parent.leftChild = node;
            }
            else{
                parent.rightChild = node;
            }
        }
        //进行调整
        adjust(node);
    }

    /**
     * 调整
     * @param node 需要调整的节点
     */
    public void adjust(TreeNode node){
        //如果节点为根节点，则将节点颜色变为黑色
        if(this.root == node){
            this.root.color = "black";
        }
        //如果当前节点的父节点颜色为红色
        else if(node.parent != null && node.parent.color.equals("red")){
            //如果父节点是左孩子
            if(node.parent.parent != null && node.parent == node.parent.parent.leftChild){
                //将tmpNode设为当前节点的叔叔节点
                TreeNode tmpNode = node.parent.parent.rightChild;
                //如果叔叔节点是红色
                if(tmpNode != null && tmpNode.color.equals("red")){
                    //将父节点设为黑色
                    node.parent.color = "black";
                    //将叔叔节点设为黑色
                    tmpNode.color = "black";
                    //将祖父节点设为红色
                    tmpNode.parent.color = "red";
                    //将祖父节点设为当前节点
                    node = tmpNode.parent;
                    adjust(node);
                }
                //如果叔叔节点是黑色，而且当前节点是右孩子
                else if(node == node.parent.rightChild){
                    //将父节点设为当前节点，并进行左旋
                    node = node.parent;
                    leftRotate(node);
                    //接着进行调整
                    adjust(node);
                }
                //如果叔叔节点是黑色，而且当前节点是左孩子
                else{
                    //将父节点设为黑色
                    node.parent.color = "black";
                    //将祖父节点设为红色
                    node.parent.parent.color = "red";
                    //将祖父节点进行右旋
                    rightRotate(node.parent.parent);
                }
            }
            else if(node.parent.parent != null){
                //将tmpNode设为当前节点的叔叔节点
                TreeNode tmpNode = node.parent.parent.leftChild;
                //如果叔叔节点是红色
                if(tmpNode != null && tmpNode.color.equals("red")){
                    //将父节点设为黑色
                    node.parent.color = "black";
                    //将叔叔节点设为黑色
                    tmpNode.color = "black";
                    //将祖父节点设为红色
                    tmpNode.parent.color = "red";
                    //将祖父节点设为当前节点
                    node = tmpNode.parent;
                    adjust(node);
                }
                //如果叔叔节点是黑色，而且当前节点是左孩子
                else if(node == node.parent.leftChild){
                    //将父节点设为当前节点，并进行右旋
                    node = node.parent;
                    rightRotate(node);
                    //接着进行调整
                    adjust(node);
                }
                //如果叔叔节点是黑色，而且当前节点是右孩子
                else{
                    //将父节点设为黑色
                    node.parent.color = "black";
                    //将祖父节点设为红色
                    node.parent.parent.color = "red";
                    //将祖父节点进行左旋
                    leftRotate(node.parent.parent);
                }
            }
        }
    }
}
