package com.uptowncat.array;

/**
 * Created by shiwang.xie on 2018/2/21.
 */
public class MaxSubArraySum {
    /**
     * O(n)
     * @param arr
     */
    private void solutionOne(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = arr[i] > sum+arr[i] ? arr[i] : sum+arr[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        maxSubArraySum.solutionOne(arr);
    }
}
