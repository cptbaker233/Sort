package com.igeek.归并排序法;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i ++) { 
            arr[i] = r.nextInt(100000) + 1;
        }
        System.out.println("排序前:\n" + Arrays.toString(arr));
        LinkedList<Integer> ll = new LinkedList<Integer>();   //为了方便操作,将数组存入集合
        for (int i = 0; i < arr.length; i ++) {
            ll.add(arr[i]);
        }
        long start = System.currentTimeMillis();
        ll = merge(ll);
        long time = System.currentTimeMillis() - start;
        for (int i = 0; i < arr.length; i ++) {             //排序完成后把数列重新存进数组输出
            arr[i] = ll.get(i);
        }
        System.out.println("排序后:\n" + Arrays.toString(arr));
        System.out.println("用时:" + time);
        System.out.println(arr.length);
    }
  
    //归并排序算法
    public static LinkedList<Integer> merge(LinkedList<Integer> ll) {
        if (ll.size() == 1) {       //递归出口,如果分无可分则不继续分,直接返回集合
            return ll;
        }
        LinkedList<Integer> ll1 = new LinkedList<Integer>();
        LinkedList<Integer> ll2 = new LinkedList<Integer>();
        for (int i = 1; ll.size() > 0;) {
            if (i == 1) {
                ll1.addLast(ll.removeLast());
                i = 0;
            } else {
                ll2.addLast(ll.removeLast());
                i = 1;
            }
        }
        ll1 = merge(ll1);           //利用递归使第一组有序
        ll2 = merge(ll2);           //利用递推使第二组有序
        ll = merg(ll1, ll2);        //输入有序的两个集合,使合并后的集合有序
        return ll;
     }
    //两个有序数列,使合并后有序
    public static LinkedList<Integer> merg(LinkedList<Integer> al1, LinkedList<Integer> al2) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (al1.size() != 0 || al2.size() != 0) {
            if (al1.size() == 0 ) {                 //实际上归并排序不会出现的情况,归并一般平均分组
                while (al2.size() > 0) {
                    result.addLast(al2.removeFirst());
                }
                return result;
            }
            if (al2.size() == 0 ) {
                while (al1.size() > 0) {
                    result.addLast(al1.removeFirst());
                }
                return result;
            }
            if (al1.getFirst() <= al2.getFirst()) {     //比较两组第一个数的大小,把小值加到结果result集合
                result.addLast(al1.removeFirst());
            } else {
                result.addLast(al2.removeFirst());
            }
        }
        return result;
    }
}