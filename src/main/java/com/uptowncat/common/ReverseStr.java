package com.uptowncat.common;

/**
 * Created by UpTownCat on 2017/12/17.
 */
public class ReverseStr {
    /**
     * reverse string with O(1) space and O(index*n) time
     * @param str
     * @param index
     * @return
     */
    public String reverseStr1(final String str, final Integer index) {
        char[] chars = str.toCharArray();
        int begin = index;
        while (begin > 0) {
            moveFirstToLast(chars);
            begin--;
        }
        return String.valueOf(chars);
    }

    /**
     * reverse string with O(1) space and O(n) time
     * @param str
     * @param index
     * @return
     */
    public String reverseStr2(final String str, final Integer index) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        reverseIntervalArr(chars, 0, index - 1);
        reverseIntervalArr(chars, index, n - 1);
        reverseIntervalArr(chars, 0, n - 1);
        return String.valueOf(chars);
    }

    /**
     * reverse a array from from to to
     * @param chars
     * @param from
     * @param to
     */
    private void reverseIntervalArr(char[] chars, int from, int to) {
        int begin = from;
        int end = to;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin++] = chars[end];
            chars[end--] = temp;
        }
    }

    /**
     * move the first item to last
     * @param chars
     */
    private void moveFirstToLast(char[] chars) {
        char temp = chars[0];
        int n = chars.length;
        for(int i = 1; i < n; i++) {
            chars[i-1] = chars[i];
        }
        chars[n-1] = temp;
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        String str = "abcdefg";
        System.out.println(reverseStr.reverseStr1(str, 2));
        System.out.println(reverseStr.reverseStr2(str, 2));
    }
}


