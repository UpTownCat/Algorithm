package com.uptowncat.search;

/**
 * Created by UpTownCat on 2017/9/19.
 */
public class BinarySearch {
    /**
     * 二分搜索
     * @param arr
     * @param target
     * @return
     */
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = (left + right) / 2;
            //中间值小于目标值
            if(arr[middle] < target) {
                left = middle + 1;
            }else {
                //中间值大于目标值
                if(arr[middle] > target) {
                    right = middle;
                }else {
                    return middle;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] arr = {1, 3, 5, 33, 44, 66, 68, 69, 300, 30002, 99999};
        int result1 = search.search(arr, 99999);
        int result2 = search.search(arr, -1);
        System.out.println(result1 + "  ---------  " + result2);
    }

}
