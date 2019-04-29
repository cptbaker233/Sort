package com.igeek.�鲢����;

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
        System.out.println("����ǰ:\n" + Arrays.toString(arr));
        LinkedList<Integer> ll = new LinkedList<Integer>();   //Ϊ�˷������,��������뼯��
        for (int i = 0; i < arr.length; i ++) {
            ll.add(arr[i]);
        }
        long start = System.currentTimeMillis();
        ll = merge(ll);
        long time = System.currentTimeMillis() - start;
        for (int i = 0; i < arr.length; i ++) {             //������ɺ���������´���������
            arr[i] = ll.get(i);
        }
        System.out.println("�����:\n" + Arrays.toString(arr));
        System.out.println("��ʱ:" + time);
        System.out.println(arr.length);
    }
  
    //�鲢�����㷨
    public static LinkedList<Integer> merge(LinkedList<Integer> ll) {
        if (ll.size() == 1) {       //�ݹ����,������޿ɷ��򲻼�����,ֱ�ӷ��ؼ���
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
        ll1 = merge(ll1);           //���õݹ�ʹ��һ������
        ll2 = merge(ll2);           //���õ���ʹ�ڶ�������
        ll = merg(ll1, ll2);        //�����������������,ʹ�ϲ���ļ�������
        return ll;
     }
    //������������,ʹ�ϲ�������
    public static LinkedList<Integer> merg(LinkedList<Integer> al1, LinkedList<Integer> al2) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        while (al1.size() != 0 || al2.size() != 0) {
            if (al1.size() == 0 ) {                 //ʵ���Ϲ鲢���򲻻���ֵ����,�鲢һ��ƽ������
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
            if (al1.getFirst() <= al2.getFirst()) {     //�Ƚ������һ�����Ĵ�С,��Сֵ�ӵ����result����
                result.addLast(al1.removeFirst());
            } else {
                result.addLast(al2.removeFirst());
            }
        }
        return result;
    }
}