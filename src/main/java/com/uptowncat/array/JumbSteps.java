package com.uptowncat.array;

/**
 * Created by shiwang.xie on 2018/2/21.
 */
public class JumbSteps {
    /**
     * O(n)
     * @param n
     */
    private void solutionOne(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]);
    }

    public static void main(String[] args) {
        JumbSteps jumbSteps = new JumbSteps();
        jumbSteps.solutionOne(6);
    }
}
