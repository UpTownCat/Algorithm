package com.uptowncat.sort;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/14.
 */
public class Utils {
    private Utils(){}

    /**
     * 交换数组的两个数
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 复制数组
     * @param arr
     * @return
     */
    public static int[] copy(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    /**
     * 判断数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean equal(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("arr1: " + Arrays.toString(arr1));
                System.out.println("arr2: " + Arrays.toString(arr2));
                return false;
            }
        }
        return true;
    }

    /**
     * 划分数组
     * @param arr
     * @return int
     */
    public static int split(int arr[], int start, int end) {
        int k = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (right > left && arr[right] > k) right--;
            while (left < right && arr[left] <= k) left++;
            Utils.swap(arr, left, right);
        }
        arr[start] = arr[left];
        arr[left] = k;
        return left;
    }
}
