package com.igeek.快速排序法;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = r.nextInt(90) + 10;
        }
        //int[] arr = {15, 73, 76, 32, 32, 21, 57, 82, 49, 19};    //测试用例1
        //int[] arr = {15, 15, 15, 32, 32, 32, 32, 32, 32, 32};    //测试用例2
        System.out.println("排序前:\n" + Arrays.toString(arr));
        arr = quick(arr, 0, arr.length - 1);
        System.out.println("排序后:\n" + Arrays.toString(arr));
    }
    
    //快速排序算法把数组索引从s到e的元素从小到大排列
    public static int[] quick(int[] arr,int s, int e) {
        int start = s;
        int end = e;
        if (end - start == 1 || end == start) {             //递归出口,如果最终排列长度为2,则直接比较大小排序,如果为1,直接输出原数组
            if (arr[start] <= arr[end]) {
                return arr;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                return arr;
            }
        }
        int keyValue = arr[start];                      //一般设定第一项元素为关键值
        int key = start;                                //关键值的索引赋值给key
        while (start < end) {                           //只要右标记索引大于左标记索引就执行换位
            if (key == start && key != end) {                         //如果key从左标记开始,则右标记递减检索将第一个比关键值小的元素与关键值元素换位
                while (arr[end] >= keyValue) {          //更换位置完成之后将key对准关键值的索引,此时key=end
                    end --;
                    if (start == end) {     //这里防止出现start > end的情况
                        break;
                    }
                }
                arr[key] = arr[end];
                arr[end] = keyValue;
                key = end;
                System.out.println("关键值" + keyValue + "交换位置后:" + Arrays.toString(arr) + "左标记:" + arr[start] + "右标记:" + arr[end]);
            }
            if (key == end && key != start) {                           //如果key从右标记开始,则左标记递增检索将第一个比关键值大的元素与关键值元素换位
                while (arr[start] <= keyValue) {        //更换位置完成之后将key对准关键值的索引,此时key=start,如此循环直到start = end跳出循环
                    start ++;
                    if (start == end) {
                        break;
                    }
                }
                arr[key] = arr[start];
                arr[start] = keyValue;
                key = start;
                System.out.println("关键值" + keyValue + "交换位置后:" + Arrays.toString(arr) + "左标记:" + arr[start] + "右标记:" + arr[end]);
            }
        }
        int keyMirror = key;            //跳出循环之后根据key将数组分成两个部分
        if (s == keyMirror && e >= keyMirror + 1) {      //特殊情况判断,若key与左标记重合,且右标记不与它们重合
            quick(arr, keyMirror + 1, e);               //只对key+1到e的范围排序
        } else if (e == keyMirror && s <= keyMirror - 1) {  //若key与右标记重合,且不与左标记重合
            quick(arr, 0, keyMirror - 1);               //只对s到key-1的范围排序
        } else {                          //一般情况,分别对左边和右边进行排序
            quick(arr, s, keyMirror);
            quick(arr, keyMirror, e);
        }
        return arr;                     //此时左边从小到大,右边也是从小到大,左边都比关键值小,右边都比关键值大,判定数列排列整齐
    }
}
