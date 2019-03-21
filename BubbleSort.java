package com.igeek.√∞≈›≈≈–Ú∑®;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        System.out.println("≈≈–Ú«∞:\n" + Arrays.toString(arr));
        arr = bubble(arr);
        System.out.println("≈≈–Ú∫Û:\n" + Arrays.toString(arr));
    }
    
    //√∞≈›≈≈–Ú∑®
    public static int[] bubble(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}
