package com.uptowncat.array;

import com.uptowncat.sort.QuickSort;

/**
 * Created by shiwang.xie on 2018/2/14.
 * find to numbers from arr with sum equals k
 */
public class SumKNumber {
    /**
     * O(n*n)
     * @param arr
     * @param k
     */
    private void solutionOne(int[] arr, int k) {
        boolean found = false;
        for (int i = 0; i < arr.length - 1; i++) {
            int num1 = arr[i];
            if (!found) {
                for (int j = i+1; j < arr.length; j++) {
                    int num2 = arr[j];
                    if (num1 + num2 == k) {
                        found = true;
                        System.out.println(num1 + ", " + num2);
                        break;
                    }
                }
            }else {
                break;
            }
        }
        if (!found) {
            System.out.println("not found!");
        }
    }

    /**
     * O(n * log(n))
     * @param arr
     * @param k
     */
    private void solutionTwo(int[] arr, int k) {
        boolean found = false;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if ( sum == k) {
                System.out.println(arr[left] + ", " + arr[right]);
                found = true;
                break;
            }else {
                if (sum > k) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        if (!found) {
            System.out.println("not found!");
        }
    }

    public static void main(String[] args) {
        SumKNumber sumKNumber = new SumKNumber();
        int[] arr = {1, 2, 4, 7, 11, 15};
        sumKNumber.solutionOne(arr, 15);
        sumKNumber.solutionTwo(arr, 15);
    }
}
