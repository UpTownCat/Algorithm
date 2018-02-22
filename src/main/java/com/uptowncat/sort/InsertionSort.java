package com.uptowncat.sort;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/14.
 */
public class InsertionSort {
    /**
     * 插入排序
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > k; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {1, 2, 4,3, 53};
        insertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
