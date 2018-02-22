package com.uptowncat.sort;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/14.
 */
public class SelectionSort {
    /**
     * 选择排序
     * @param arr
     */
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index = 0;
            for (int j = 1; j <= arr.length - i; j++) {
                if (arr[index] < arr[j]) {
                    index = j;
                }
            }
            Utils.swap(arr, index, arr.length - i);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectSort = new SelectionSort();
        int[] arr = {1, 2, 4,3, 53};
        selectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
