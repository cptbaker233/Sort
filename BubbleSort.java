package com.igeek.ð������;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        System.out.println("����ǰ:\n" + Arrays.toString(arr));
        arr = bubble(arr);
        System.out.println("�����:\n" + Arrays.toString(arr));
    }
    
    //ð������
    public static int[] bubble(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i --) { //ÿ�α��������鳤��-1
            for (int j = 0; j < i; j ++) {           
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];               //����ұ߱ȸó�ԱС,��λ��
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }
}