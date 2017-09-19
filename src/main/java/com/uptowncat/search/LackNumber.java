package com.uptowncat.search;

/**
 * Created by UpTownCat on 2017/9/19.
 */
public class LackNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11};
        System.out.println(new LackNumber().search(arr));
    }

    /**
     * 寻找缺失的数
     * @param arr
     * @return
     */
    public int search(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            res ^= ((i + 1) ^ arr[i]);
        }
        return res;
    }
}
