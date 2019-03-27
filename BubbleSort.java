package com.igeek.冒泡排序法;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        System.out.println("排序前:\n" + Arrays.toString(arr));
        arr = bubble(arr);
        System.out.println("排序后:\n" + Arrays.toString(arr));
    }
    
    //冒泡排序法
    public static int[] bubble(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i --) { //每次遍历的数组长度-1
            for (int j = 0; j < i; j ++) {           
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];               //如果右边比该成员小,则换位置
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}