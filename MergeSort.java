package com.igeek.�鲢����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        System.out.println("����ǰ:\n" + Arrays.toString(arr));
        ArrayList<Integer> al = new ArrayList<Integer>();   //Ϊ�˷������,��������뼯��
        for (int i = 0; i < arr.length; i ++) {
            al.add(arr[i]);
        }
        al = merge(al);
        for (int i = 0; i < arr.length; i ++) {             //������ɺ���������´���������
            arr[i] = al.get(i);
        }
        System.out.println("�����:\n" + Arrays.toString(arr));
    }
  
    //�鲢�����㷨
    public static ArrayList<Integer> merge(ArrayList<Integer> al) {
        if (al.size() == 1) {       //�ݹ����,������޿ɷ��򲻼�����,ֱ�ӷ��ؼ���
            return al;
        }
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        for (int i = 0; i < al.size(); i ++) {              //��Ŀ�꼯��ƽ���ֳ�����
            if (i < al.size() / 2) {
                al1.add(al.get(i));
            } else {
                al2.add(al.get(i));
            }
        }
        al1 = merge(al1);           //���õݹ�ʹ��һ������
        System.out.println("A��" + al1);
        al2 = merge(al2);           //���õ���ʹ�ڶ�������
        System.out.println("B��" + al2);
        al = merg(al1, al2);        //�����������������,ʹ�ϲ���ļ�������
        System.out.println("�ϲ�:" + al);
        return al;
     }
    //������������,ʹ�ϲ�������
    public static ArrayList<Integer> merg(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (al1.size() != 0 || al2.size() != 0) {
            if (al1.size() == 0 ) {                 //ʵ���Ϲ鲢���򲻻���ֵ����,�鲢һ��ƽ������
                while (al2.size() != 0 ) {          //������Ϊ�����������������ó���,ʹ��ƽ����������Ҳ����
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
            if (al1.get(0) <= al2.get(0)) {     //�Ƚ������һ�����Ĵ�С,��Сֵ�ӵ����result����
                result.add(al1.remove(0));
            } else {
                result.add(al2.remove(0));
            }
        }
        return result;
    }
}