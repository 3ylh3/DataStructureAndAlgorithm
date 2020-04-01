package com.xiaobai.datastructure.jianzhioffer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 斐波那切数列
 *
 * @author yin_zhj
 * @date 2020/4/1
 */
public class Fibonacci {
    public int fibonacci1(int i) {
        if(i <= 0) {
            return 0;
        }
        if(i == 1) {
            return 1;
        } else {
            return fibonacci1(i - 1) + fibonacci1(i - 2);
        }
    }

    public int fibonacci2(int i) {
        if(i <= 0) {
            return 0;
        }
        if(i == 1) {
            return 1;
        } else {
            int rs = 0;
            int zero = 0;
            int one = 1;
            for(int j = 2;j <= i;j++) {
                rs = zero + one;
                zero = one;
                one = rs;
            }
            return rs;
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci1(8));
        System.out.println(fibonacci.fibonacci2(8));
    }
}
