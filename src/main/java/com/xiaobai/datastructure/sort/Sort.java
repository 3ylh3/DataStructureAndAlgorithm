package com.xiaobai.datastructure.sort;

import java.util.Arrays;

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

    /**
     * 直接插入排序
     * @param a 待排序数组
     */
    public void insertSort(int[] a){
        //循环处理无序表元素
        for(int i = 1;i < a.length;i++){
            //寻找在有序表中插入位置,将后面的元素后移一位后插入
            int tmp = a[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(a[j] > tmp){
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param a 待排序数组
     * @param increment 步长
     */
    public void shellSort(int[] a,int increment){
        //每次步长变为原来的一半
        for(;increment > 0;increment /= 2){
            //共increment个组，对每个组进行直接插入排序
            for(int in = 0;in < increment;in++){
                for(int i = in + increment;i < a.length;i += increment){
                    //寻找在有序表中插入位置,将后面的元素后移一位后插入
                    int tmp = a[i];
                    int j = i - increment;
                    for(;j >= in;j -= increment){
                        if(a[j] > tmp){
                            a[j + increment] = a[j];
                            a[j] = tmp;
                        }
                    }
                }
            }
        }
    }

    /**
     * 选择排序
     * @param a 待排序数组
     */
    public void selectSort(int[] a){
        //从a[0]开始
        for(int i = 0;i < a.length;i++){
            //找出a[j] - a[a.length - 1]中最小的数
            int min = i;
            for(int j = i + 1;j < a.length;j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            //和a[i]交换
            int tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

    /**
     * 堆排序
     * @param a 待排序数组
     */
    public void heapSort(int[] a){
        //将数组调整成大根堆,从最后一个非叶子节点开始调整
        for(int i = a.length / 2 - 1;i >= 0;i--) {
            adjust(a,i,a.length);
        }
        //将第一个数和最后一个数交换，然后将数组前面内容重新调整成大根堆
        for(int i = a.length - 1;i >= 0;i--){
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            //从最后一个非叶子节点开始调整，将剩余数组调整成大根堆
            for(int j = i / 2 - 1;j >= 0;j--){
                adjust(a,j,i);
            }
        }
    }

    /**
     * 大根堆调整算法
     * @param a 待调整数组
     * @param index 调整的节点
     * @param length 待调整数组长度
     */
    public void adjust(int[] a,int index,int length){
        //记左右孩子中最大值的索引为max
        int max = index * 2 + 1;
        if ((index * 2 + 2) < length && a[max] < a[index * 2 + 2]) {
            max = index * 2 + 2;
        }
        //如果a[index]小于a[max]，则交换两者
        if (a[index] < a[max]) {
            int tmp = a[index];
            a[index] = a[max];
            a[max] = tmp;
            //如果max节点有孩子，则递归调整
            if (max * 2 + 1 < length) {
                adjust(a,max,length);
            }
        }
    }

    /**
     * 归并排序
     * @param a 待排序数组
     * @param start 开始位置
     * @param end 结束位置
     */
    public void mergeSort(int[] a,int start,int end){
        if(start < end){
            int mid = (end + start) / 2;
            //递归对左右两个序列进行排序
            mergeSort(a,start,mid);
            mergeSort(a,mid + 1,end);
            //合并两个有序序列
            merge(a,start,mid,end);
        }
    }

    /**
     * 合并两个有序序列
     * @param a 待合并序列
     * @param start 起始位置
     * @param mid 中间位置（第一个序列结束位置）
     * @param end 结束位置
     */
    public void merge(int[] a,int start,int mid,int end){
        //辅助数组
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        //遍历第一个有序序列
        while(i <= mid){
            //如果第二个有序序列没有遍历完
            if(j <= end){
                //比较两个序列当前元素，将较小的放到辅助数组中
                if(a[i] < a[j]){
                    tmp[k] = a[i];
                    i++;
                }
                else{
                    tmp[k] = a[j];
                    j++;
                }
            }
            //如果第二个数组已经遍历完，则将第一个序列中剩余的数都放到辅助数组中
            else{
                tmp[k] = a[i];
                i++;
            }
            k++;
        }
        //如果第二个序列还没有遍历完，则将剩余的数全部放到辅助数组中
        while(j <= end){
            tmp[k] = a[j];
            j++;
            k++;
        }
        //将辅助数组中的数复制到原数组
        System.arraycopy(tmp,0,a,start,tmp.length);
    }
}
