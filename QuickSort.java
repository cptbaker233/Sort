package com.igeek.��������;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        //int[] arr = {15, 73, 76, 32, 32, 21, 57, 82, 49, 19};    //��������1
        //int[] arr = {15, 15, 15, 32, 32, 32, 32, 32, 32, 32};    //��������2
        System.out.println("����ǰ:\n" + Arrays.toString(arr));
        arr = quick(arr, 0, arr.length - 1);
        System.out.println("�����:\n" + Arrays.toString(arr));
    }
    
    //���������㷨������������s��e��Ԫ�ش�С��������
    public static int[] quick(int[] arr,int s, int e) {
        int start = s;
        int end = e;
        if (end - start == 1 || end == start) {             //�ݹ����,����������г���Ϊ2,��ֱ�ӱȽϴ�С����,���Ϊ1,ֱ�����ԭ����
            if (arr[start] <= arr[end]) {
                return arr;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                return arr;
            }
        }
        int keyValue = arr[start];                      //һ���趨��һ��Ԫ��Ϊ�ؼ�ֵ
        int key = start;                                //�ؼ�ֵ��������ֵ��key
        while (start < end) {                           //ֻҪ�ұ��������������������ִ�л�λ
            if (key == start && key != end) {                         //���key�����ǿ�ʼ,���ұ�ǵݼ���������һ���ȹؼ�ֵС��Ԫ����ؼ�ֵԪ�ػ�λ
                while (arr[end] >= keyValue) {          //����λ�����֮��key��׼�ؼ�ֵ������,��ʱkey=end
                    end --;
                    if (start == end) {     //�����ֹ����start > end�����
                        break;
                    }
                }
                arr[key] = arr[end];
                arr[end] = keyValue;
                key = end;
                System.out.println("�ؼ�ֵ" + keyValue + "����λ�ú�:" + Arrays.toString(arr) + "����:" + arr[start] + "�ұ��:" + arr[end]);
            }
            if (key == end && key != start) {                           //���key���ұ�ǿ�ʼ,�����ǵ�����������һ���ȹؼ�ֵ���Ԫ����ؼ�ֵԪ�ػ�λ
                while (arr[start] <= keyValue) {        //����λ�����֮��key��׼�ؼ�ֵ������,��ʱkey=start,���ѭ��ֱ��start = end����ѭ��
                    start ++;
                    if (start == end) {
                        break;
                    }
                }
                arr[key] = arr[start];
                arr[start] = keyValue;
                key = start;
                System.out.println("�ؼ�ֵ" + keyValue + "����λ�ú�:" + Arrays.toString(arr) + "����:" + arr[start] + "�ұ��:" + arr[end]);
            }
        }
        int keyMirror = key;            //����ѭ��֮�����key������ֳ���������
        if (s == keyMirror && e >= keyMirror + 1) {      //��������ж�,��key�������غ�,���ұ�ǲ��������غ�
            quick(arr, keyMirror + 1, e);               //ֻ��key+1��e�ķ�Χ����
        } else if (e == keyMirror && s <= keyMirror - 1) {  //��key���ұ���غ�,�Ҳ��������غ�
            quick(arr, 0, keyMirror - 1);               //ֻ��s��key-1�ķ�Χ����
        } else {                          //һ�����,�ֱ����ߺ��ұ߽�������
            quick(arr, s, keyMirror);
            quick(arr, keyMirror, e);
        }
        return arr;                     //��ʱ��ߴ�С����,�ұ�Ҳ�Ǵ�С����,��߶��ȹؼ�ֵС,�ұ߶��ȹؼ�ֵ��,�ж�������������
    }
}
