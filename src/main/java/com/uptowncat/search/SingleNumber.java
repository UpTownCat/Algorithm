package com.uptowncat.search;

/**
 * Created by UpTownCat on 2017/9/19.
 */
public class SingleNumber {
    /**
     * 寻找只出现一次的数(其余的数都出现两次)
     * @param arr
     * @return
     */
    public int searchFromTwice(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    /**
     * 寻找只出现一次的数（其余的出现三次）
     * @param nums
     * @return
     */
    public int searchFromThree(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum % 3) << i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 4, 4, 5, 5};
        System.out.println(new SingleNumber().searchFromTwice(arr));
        int[] arr2 = {1, 2, 3, 1, 2, 4, 4, 5, 5, 5, 4, 2, 1, 3, 12, 3};
        System.out.println(new SingleNumber().searchFromThree(arr2));
        System.out.println(0 & 8 | 4);
    }
}
