package com.igeek.插入排序法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i ++) {
            arr[i] = r.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(arr));
        arr = insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    //利用插入方法,进行排序
    public static int[] insert(int[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add((arr[0] <= arr[1] ? arr[0] : arr[1]));
        al.add((arr[0] >= arr[1] ? arr[0] : arr[1]));
        //System.out.println(al);
        for (int i = 2; i < arr.length; i ++) {
            in(al, arr[i]);
        }
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = al.get(i);
        }
        return arr;
    }
    
    //插入有序数组(利用二分发查找位置)
    public static ArrayList<Integer> in(ArrayList<Integer> al, int a){
        if (a >= al.get(al.size() - 1)) {
            al.add(a);
            return al;
        }
        if (a <= al.get(0)) {
            al.add(0, a);
            return al;
        }
        int start = 0;
        int end = al.size() - 1;
        int key = (start + end) - 1;
        for (key = (start + end) / 2; start < end - 1; key = (start + end) / 2) {
            if (a > al.get(key)) {
                start = key;
            } else {
                end = key;
            }
        }
        al.add(end, a);
        return al;
    }
}
