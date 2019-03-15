package com.xiaobai.datastructure.sort;

public class Sort {
    /**
     * 冒泡排序
     * @param a 需要排序的整型数组
     */
    public void bubbleSort(int[] a){
        for(int i = 1;i <= a.length;i++){
            for(int j = 0;j < a.length - i;j++){
                //从数组第一个数开始，依次和它后面的数比较，如果比后面的数大，则交换位置
                if(a[j] > a[j + 1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param a 需要排序的数组
     * @param l 左边界
     * @param r 右边界
     */
    public void quickSort(int[] a,int l,int r){
        if(l >= r){
            return;
        }
        //基准值取a[i]
        int base = a[l];
        int i = l;
        int j = r;
        //当i小于j时循环
        while(i < j){
            //从右向左找出第一个小于base的数，和a[i]交换
            while(i < j){
                if(a[j] < base){
                    a[i] = a[j];
                    break;
                }
                else{
                    j--;
                }
            }
            //从左向右找出第一个大于base的数，和a[j]交换
            while(i < j){
                if(a[i] > base){
                    a[j] = a[i];
                    break;
                }
                else{
                    i++;
                }
            }
        }
        //将a[i]设为base
        a[i] = base;
        //递归调用
        quickSort(a,l,i - 1);
        quickSort(a,i + 1,r);
    }
}
