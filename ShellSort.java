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
        int[] temp = new int[arr.length];
        for(int  gap = arr.length / 2; gap >= 1; gap /= 2) {            //ϣ������ļ��gap�ӳ���һ�뿪ʼ���εݼ�
            System.out.println("===============��ǰ���gap:" + gap + "===============");
            System.out.println(Arrays.toString(arr));
            for (int group = 0; group < gap; group ++) {            //һ��gap�ֳ�ȷ������,���Ϊ��0�鵽1��һֱ��gap-1��
                System.out.println("��"+ (group + 1) + "����������:");
                ArrayList<Integer> al = new ArrayList<Integer>();
                for (int j = group; j < arr.length; j += gap) {     //ÿһ��ĳ�Ա֮������gap
                    InsertSort.in(al, arr[j]);
                }
                for (int j = group,i = 0; j < arr.length; j += gap,i ++) { //�����ϵ�Ԫ�ش���temp1
                    temp[j] = al.get(i);
                }
                System.out.println("al :" + al);
                System.out.println("����" + (group + 1) + "��Ժ��������������:\n" + Arrays.toString(temp));
            }
            arr = temp;
        }
        return arr;
    }
}
