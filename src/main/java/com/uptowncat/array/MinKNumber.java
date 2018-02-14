package com.uptowncat.array;

import com.uptowncat.sort.QuickSort;
import com.uptowncat.sort.Utils;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/1.
 * find min k numbers from arr
 */
public class MinKNumber {

    /**
     * O(k * n)
     * @param arr
     * @param k
     * @return
     */
    private int[] solutionOne(int[] arr, int k) {
        if (k > arr.length) {
            return arr;
        }
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            int minNum = arr[j];
            int minIndex = j;
            for (int i = j; i < arr.length; i++) {
                if (minNum > arr[i]) {
                    minNum = arr[i];
                    minIndex = i;
                }
            }
            result[j] = minNum;
            Utils.swap(arr, j, minIndex);
        }
        return result;
    }

    /**
     * O(n * logn)
     * @param arr
     * @param k
     * @return
     */
    private int[] solutionTwo(int[] arr, int k) {
        if (k > arr.length) {
            return arr;
        }
        int[] result = new int[k];
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * O(n)
     * @param arr
     * @param k
     * @return
     */
    private int[] solutionThree(int[] arr, int k) {
        int[] result = new int[k];
        if (k > arr.length) {
            return arr;
        }
        processArr(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    /**
     * process arr to split min k numbers
     * @param arr
     * @param start
     * @param end
     */
    private void processArr(int[] arr, int start, int end, int k) {
        if (k == 0) {
            return;
        }
        int index = Utils.split(arr, start, end);
        int length = index - start + 1;
        if (length > k) {
            processArr(arr, start, length, k);
        }else {
            if (length == k) {
                processArr(arr, start, length, 0);
            }else {
                processArr(arr, index + 1, end, k - length);
            }
        }
    }



    public static void main(String[] args) {
        MinKNumber minKNumber = new MinKNumber();
        int[] arr = {2, 4324, 234, 2,31, 43, 42, 32, 76, 4, 8, 0};
        System.out.println(Arrays.toString(minKNumber.solutionOne(arr, 6)));
        System.out.println(Arrays.toString(minKNumber.solutionTwo(arr, 5)));
        System.out.println(Arrays.toString(minKNumber.solutionThree(arr, 5)));
    }

}
