package com.igeek.快速排序法;

import java.util.Arrays;
import java.util.Random;

/**  
* @typename QuickSort_Retry01  
* @author NFUE  
* @Description: 快速排序算法
* @date 2019年4月9日 下午9:04:10    
* @Company https://github.com/cptbaker233
*    
*/
public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(100);
        }
        //int[] arr = {0,6,10,5,5,5,10};
        System.out.println(Arrays.toString(arr));
        arr = quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    //快速排序算法
    public static int[] quickSort(int[] arr) {
        return quickSortPart(arr, 0, arr.length - 1);
    }
    
    //局部快排算法
    public static  int[] quickSortPart(int[] arr, int start, int end) {
        if (end - start == 0) {
            return arr;
        }
        if (end - start == 1) {
            if (arr[start] > arr[end]) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            return arr;
        }
        int s = start;
        int e = end;
        int key = s;
        while (s < e) {
            if (key == s) {
                if (arr[e] < arr[key]) {
                    int temp = arr[e];
                    arr[e] = arr[key];
                    arr[key] = temp;
                    key = e;
                    continue;
                }
                e --;
                continue;
            }
            if (key == e) {
                if (arr[s] > arr[key]) {
                    int temp = arr[s];
                    arr[s] = arr[key];
                    arr[key] = temp;
                    key = s;
                    continue;
                }
                s ++;
                continue;
            }
        }
        if (key == start) {
            return quickSortPart(arr, key + 1, end);
        }
        if (key == end) {
            return quickSortPart(arr, start, key - 1);
        }
        quickSortPart(arr, start, key - 1);
        quickSortPart(arr, key + 1, end);
        return arr;
    }
}
