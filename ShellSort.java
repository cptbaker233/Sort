package com.igeek.ϣ������;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import com.igeek.��������.*;

public class ShellSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i ++) {
            arr[i] = r.nextInt(10);
        }
        arr = shell(arr);
    }
    
    //ϣ������(���齻��,������һ�β�������)
    public static int[] shell(int[] arr) {
        int[] temp1 = new int[arr.length];
        int[] temp2 = new int[arr.length];
        for(int  gap = arr.length / 2; gap >= 1; gap /= 2) {
            System.out.println("===============��ǰ���gap:" + gap + "===============");
            System.out.println(Arrays.toString(arr));
            for (int group = 0; group < gap; group ++) {
                System.out.println("��"+ (group + 1) + "����������:");
                ArrayList<Integer> al = new ArrayList<Integer>();
                for (int j = group; j < arr.length; j += gap) {
                    InsertSort.in(al, arr[j]);
                }
                for (int j = group,i = 0; j < arr.length; j += gap,i ++) {
                    temp1[j] = al.get(i);
                }
                System.out.println("al :" + al);
                System.out.println("����" + (group + 1) + "��Ժ��������������:\n" + Arrays.toString(temp1));
            }
            arr = temp1;
            temp1 = temp2; 
        }
        return arr;
    }
}
