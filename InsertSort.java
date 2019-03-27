package com.igeek.��������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(arr));
        arr = insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    //���ò��뷽��,��������
    public static int[] insert(int[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        //System.out.println(al);
        for (int i = 0; i < arr.length; i ++) {
            in(al, arr[i]);
        }
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = al.get(i);
        }
        return arr;
    }
    
    //��Ŀ�����������߿ռ���(���ö��ַ�����λ��)
    public static ArrayList<Integer> in(ArrayList<Integer> al, int a){
        if (al.size() == 0) {       //��Ŀ���ǿ�����,ֱ�Ӳ���
            al.add(a);
            return al;
        }
        if (a >= al.get(al.size() - 1)) {  //Ŀ�����ȫ��ֵ,ֱ�Ӽ�������
            al.add(a);
            return al;
        }
        if (a <= al.get(0)) {  //Ŀ��С��ȫ��ֵ,ֱ�Ӽ����������
            al.add(0, a);
            return al;
        }
        int start = 0;     //Ŀ�������ͷ֮������,�ö��ֲ��Ҳ���
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
