package com.xiaobai.datastructure.search;

public class Search {
    /**
     * 二分查找
     * @param a 查找数组
     * @param value 查找值
     * @param start 起始位置
     * @param end 结束位置
     * @return
     */
    public int binarySearch(int[] a,int value,int start,int end){
        if(start == end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid] == value){
            return mid;
        }
        else if(a[mid] > value){
            return binarySearch(a,value,start,mid);
        }
        else{
            return binarySearch(a,value,mid + 1,end);
        }
    }
}
