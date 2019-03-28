package com.igeek.��������;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.igeek.ð������.BubbleSort;

public class CombSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        arr = comb(arr);
    }
    
    //��������(���齻��,���ڽ���ð������)
    public static int[] comb(int[] arr) {
        int[] temp1 = new int[arr.length];
        for(int  gap = (int) (arr.length * 0.8); gap >= 1; gap =(int)(gap * 0.8)) {            //��������ļ��gap�ӳ���һ�뿪ʼ���εݼ�
            System.out.println("===============��ǰ���gap:" + gap + "===============");
            System.out.println(Arrays.toString(arr));
            for (int group = 0; group < gap; group ++) {            //һ��gap�ֳ�ȷ������,���Ϊ��0�鵽1��һֱ��gap-1��
                System.out.println("��"+ (group + 1) + "��ð�������:");
                ArrayList<Integer> al = new ArrayList<Integer>();
                int[] temp2 = {};       //ȷ��һ��temp2����������al������,�������ð������
                for (int j = group; j < arr.length; j += gap) {     //ÿһ��ĳ�Ա֮������gap
                    al.add(arr[j]);
                    temp2 = new int[al.size()];
                    for (int i = 0; i < temp2.length; i ++) {
                        temp2[i] = al.get(i);
                    }
                    temp2 = BubbleSort.bubble(temp2);       //����ð������
                }
                for (int j = group,i = 0; j < arr.length; j += gap,i ++) { //�����ϵ�Ԫ�ش���temp1
                    temp1[j] = temp2[i];
                }
                System.out.println(Arrays.toString(temp2));
                System.out.println("����" + (group + 1) + "��Ժ��������������:\n" + Arrays.toString(temp1));
            }
            arr = temp1;
        }
        return arr;
    }
}
