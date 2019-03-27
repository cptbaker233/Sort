package com.igeek.选择排序法;

import java.util.ArrayList;
import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 1; i <= 30; i ++) {
            al.add(r.nextInt(100) + 1);
        }
        System.out.println(al);
        select(al);
        System.out.println(al);
    }
    
    //选择排序法
    public static void select(ArrayList<Integer> al) {
        for (int i = al.size() - 1; i >= 0; i --) {
            int min = al.get(0);
            int index = 0;
            for(int j = 0; j < i + 1; j ++) {
                index = (min <= al.get(j)) ? index : j;
                min = (min <= al.get(j)) ? min : al.get(j);
            }
            al.remove(index);                  //遍历数组把最小值的元素去掉
            al.add(min);                       //在数组末尾加上提取到的最小值
            System.out.println(al);
        }
    }
        
    //找出数组的最大值和索引
    public static int indexOfMax(ArrayList<Integer> al, int end) {
        int index = 0;
        int max = al.get(0);
        for (int i =0; i < end; i ++) {
            index = (max >= al.get(i)) ? max : al.get(i);
        }
        return index;
    }
}
