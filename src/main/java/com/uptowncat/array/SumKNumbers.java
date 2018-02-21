package com.uptowncat.array;

/**
 * Created by shiwang.xie on 2018/2/21.
 */
public class SumKNumbers {

    /**
     * O(2^n)
     * @param sum
     * @param n
     */
    private void solutionOne(int sum, int n) {
        int[] arr = new int[n+1];
        process(sum, n, arr);
    }

    /**
     * process for solution one
     * @param sum
     * @param n
     * @param arr
     */
    private void process(int sum, int n, int[] arr) {
        if (sum == 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1) {
                    System.out.print(i + "  ");
                }
            }
            System.out.println();
            return;
        }
        if (n <= 0) {
            return;
        }
        arr[n] = 1;
        process(sum-n, n-1, arr);
        arr[n] = 0;
        process(sum, n-1, arr);
    }

    public static void main(String[] args) {
        SumKNumbers sumKNumbers = new SumKNumbers();
        sumKNumbers.solutionOne(10, 5);
    }
}
