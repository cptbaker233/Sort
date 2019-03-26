package com.igeek.归并排序法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        System.out.println("排序前:\n" + Arrays.toString(arr));
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i ++) {
            al.add(arr[i]);
        }
        al = merge(al);
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = al.get(i);
        }
        System.out.println("排序后:\n" + Arrays.toString(arr));
    }
  
    //二向归并排序算法
    public static ArrayList<Integer> merge(ArrayList<Integer> al) {
        if (al.size() == 1) {       //递归出口,如果分无可分则不继续分,直接返回集合
            return al;
        }
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        for (int i = 0; i < al.size(); i ++) {
            if (i < al.size() / 2) {
                al1.add(al.get(i));
            } else {
                al2.add(al.get(i));
            }
            
        }
        al1 = merge(al1);           //利用递归使第一组有序
        al2 = merge(al2);           //利用递推使第二组有序
        al = merg(al1, al2);        //输入有序的两个集合,使合并后的集合有序
        System.out.println("合并:" + al);
        return al;
     }
    //两个有序数列,使合并后有序
    public static ArrayList<Integer> merg(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (al1.size() != 0 || al2.size() != 0) {
            if (al1.size() == 0 ) {                 //实际上归并排序不会出现的情况(如果其中一组没有元素,则遍历直接把另一组依次加上)
                while (al2.size() != 0 ) {          //这里是为了提升本方法的适用场景
                    result.add(al2.remove(0));
                }
                return result;
            }
            if (al2.size() == 0 ) {
                while (al1.size() != 0 ) {
                    result.add(al1.remove(0));
                }
                return result;
            }
            if (al1.get(0) <= al2.get(0)) {     //比较两组第一个数的大小,把小值加到结果集合
                result.add(al1.remove(0));
            } else {
                result.add(al2.remove(0));
            }
        }
        return result;
    }
}