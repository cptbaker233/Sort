package com.igeek.希尔排序法;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import com.igeek.插入排序法.*;

public class ShellSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i ++) {
            arr[i] = r.nextInt(10);
        }
        arr = shell(arr);
    }
    
    //希尔排序法(分组交换,最后进行一次插入排序)
    public static int[] shell(int[] arr) {
        int[] temp = new int[arr.length];
        for(int  gap = arr.length / 2; gap >= 1; gap /= 2) {            //希尔排序的间距gap从长度一半开始依次递减
            System.out.println("===============当前间距gap:" + gap + "===============");
            System.out.println(Arrays.toString(arr));
            for (int group = 0; group < gap; group ++) {            //一个gap分成确定的组,组号为从0组到1组一直到gap-1组
                System.out.println("第"+ (group + 1) + "组插入排序后:");
                ArrayList<Integer> al = new ArrayList<Integer>();
                for (int j = group; j < arr.length; j += gap) {     //每一组的成员之间间距是gap
                    InsertSort.in(al, arr[j]);
                }
                for (int j = group,i = 0; j < arr.length; j += gap,i ++) { //将集合的元素存入temp1
                    temp[j] = al.get(i);
                }
                System.out.println("al :" + al);
                System.out.println("将第" + (group + 1) + "组对号入座并入数组后:\n" + Arrays.toString(temp));
            }
            arr = temp;
        }
        return arr;
    }
}
