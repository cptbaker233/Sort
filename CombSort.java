package com.igeek.梳子排序法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.igeek.冒泡排序法.BubbleSort;

public class CombSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        arr = comb(arr);
    }
    
    //梳子排序法(分组交换,组内进行冒泡排序)
    public static int[] comb(int[] arr) {
        int[] temp1 = new int[arr.length];
        for(int  gap = (int) (arr.length * 0.8); gap >= 1; gap =(int)(gap * 0.8)) {            //梳子排序的间距gap从长度一半开始依次递减
            System.out.println("===============当前间距gap:" + gap + "===============");
            System.out.println(Arrays.toString(arr));
            for (int group = 0; group < gap; group ++) {            //一个gap分成确定的组,组号为从0组到1组一直到gap-1组
                System.out.println("第"+ (group + 1) + "组冒泡排序后:");
                ArrayList<Integer> al = new ArrayList<Integer>();
                int[] temp2 = {};       //确定一个temp2数组用来存al的数据,方便调用冒泡排序
                for (int j = group; j < arr.length; j += gap) {     //每一组的成员之间间距是gap
                    al.add(arr[j]);
                    temp2 = new int[al.size()];
                    for (int i = 0; i < temp2.length; i ++) {
                        temp2[i] = al.get(i);
                    }
                    temp2 = BubbleSort.bubble(temp2);       //组内冒泡排序
                }
                for (int j = group,i = 0; j < arr.length; j += gap,i ++) { //将集合的元素存入temp1
                    temp1[j] = temp2[i];
                }
                System.out.println(Arrays.toString(temp2));
                System.out.println("将第" + (group + 1) + "组对号入座并入数组后:\n" + Arrays.toString(temp1));
            }
            arr = temp1;
        }
        return arr;
    }
}
