package com.uptowncat.search;

/**
 * Created by UpTownCat on 2017/11/1.
 */
public class SegmentTree {

    private int getMid(int left, int right) {
        return  left + (right - left) / 2;
    }

    public int buildTree(int[] container, int[] nums, int ss, int se, int si) {

        if(ss >= se) {
            container[si] = nums[ss];
            return nums[ss];
        }
        int mid = getMid(ss, se);
        int left = buildTree(container, nums, ss, mid, si * 2 + 1);
        int right = buildTree(container, nums, mid + 1, se, si * 2 + 2);
        return container[si] = left + right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        int[] container = new int[7 * 2 + 1];
        SegmentTree segmentTree = new SegmentTree();
        segmentTree.buildTree(container, nums, 0, 6, 0);
        for(int i = 0; i < container.length; i++) {
            System.out.print(container[i] + "  ");
        }
        System.out.println();
    }
}
