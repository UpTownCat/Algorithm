package com.uptowncat.dp;

/**
 * Created by UpTownCat on 2017/10/15.
 */
public class MaxSubSeq {
    public int[] getResult(int[] nums){
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = max;
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                //increace
                dp[i] = nums[i] + dp[i - 1];
                if (max < dp[i]) {
                    max = dp[i];
                    right = i;
                }
            }else {
                //reset
                dp[i] = nums[i];
                if (max < dp[i]) {
                    max = dp[i];
                    left = i;
                    right = i;
                }
            }
        }
        System.out.println("max is " + max + " left is " + left + " right is " + right);
        return new int[]{max, left, right};
    }

    public static void main(String[] args) {
        MaxSubSeq seq = new MaxSubSeq();
        int[] nums = {1, -2, 3, 5, -1, 2};
        seq.getResult(nums);
    }
}
