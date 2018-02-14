package com.uptowncat.sort;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/1/14.
 */
public class Compare {
    public static void main(String[] args) {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10000);
        }

        int[] sysCopy = Utils.copy(arr);
        long sysStart = System.currentTimeMillis();
        Arrays.sort(sysCopy);
        long sysEnd = System.currentTimeMillis();
        System.out.println(String.format("sys sort %d ", sysEnd - sysStart));

        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleCopy = Utils.copy(arr);
        long bubbleStart = System.currentTimeMillis();
        bubbleSort.sort(bubbleCopy);
        long bubbleEnd = System.currentTimeMillis();
        System.out.println(String.format("bubble sort %d", bubbleEnd - bubbleStart));
        System.out.println("bubble sort equal: " + Utils.equal(sysCopy, bubbleCopy));

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionCopy = Utils.copy(arr);
        long selectionStart = System.currentTimeMillis();
        selectionSort.sort(selectionCopy);
        long selectionEnd = System.currentTimeMillis();
        System.out.println(String.format("selection sort %d", selectionEnd - selectionStart));
        System.out.println("selection sort equal: " + Utils.equal(sysCopy, selectionCopy));

        InsertionSort insertionSort = new InsertionSort();
        int[] insertionCopy = Utils.copy(arr);
        long insertionStart = System.currentTimeMillis();
        insertionSort.sort(insertionCopy);
        long insertionEnd = System.currentTimeMillis();
        System.out.println(String.format("insertion sort %d", insertionEnd - insertionStart));
        System.out.println("insertion sort equal: " + Utils.equal(sysCopy, insertionCopy));

        QuickSort quickSort = new QuickSort();
        int[] quickCopy = Utils.copy(arr);
        long quickStart = System.currentTimeMillis();
        quickSort.sort(quickCopy);
        long quickEnd = System.currentTimeMillis();
        System.out.println(String.format("quick sort %d", quickEnd - quickStart));
        System.out.println("quick sort equal: " + Utils.equal(sysCopy, quickCopy));
//        System.out.println("origin arr: " + Arrays.toString(arr));
    }
}
