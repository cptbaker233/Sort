package com.igeek.��������;

import java.util.Arrays;
import java.util.Random;

/**  
* @typename QuickSort 
* @author NFUE  
* @Description: ���������㷨
* @date 2019��4��9�� ����9:04:10    
* @Company https://github.com/cptbaker233
*    
*/
public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(100000);
        }
        System.out.println(Arrays.toString(arr));
        //int[] arr = {0,6,10,5,5,5,10};
        long start = System.currentTimeMillis();
        arr = quickSort(arr);
        long time = System.currentTimeMillis() - start;
        System.out.println(Arrays.toString(arr));
        System.out.println("��ʱ:" + time);
        System.out.println(arr.length);
    }
    
    //���������㷨
    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }
    
    //�ֲ������㷨
    public static  int[] quickSort(int[] arr, int start, int end) {
        if (end - start == 0) {
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
            return quickSort(arr, key + 1, end);
        }
        if (key == end) {
            return quickSort(arr, start, key - 1);
        }
        quickSort(arr, start, key - 1);
        quickSort(arr, key + 1, end);
        return arr;
    }
}
