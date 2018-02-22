package com.uptowncat.sort;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/14.
 */
public class BubbleSort {
    /**
     * 冒泡排序
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    Utils.swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 2, 4,3, 53};
        bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
