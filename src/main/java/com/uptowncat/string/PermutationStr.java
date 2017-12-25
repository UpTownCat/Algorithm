package com.uptowncat.string;

public class PermutationStr {

    /**
     * permutation str recursive
     * @param chars
     * @param k
     */
    public void permutationStrOne(char[] chars, int k) {

        if (k == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }

        for (int i = k; i < chars.length; i++) {
            swrap(chars, k, i);
            permutationStrOne(chars, k+1);
            swrap(chars, k, i);
        }
    }

    /**
     * swrap chars[i] chars[j]
     * @param chars
     * @param i
     * @param j
     */
    private void swrap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * use dictionary order
     * @param chars
     */
    public void permutationStrTwo(char[] chars) {
        while (handle(chars)) {
            System.out.println(String.valueOf(chars));
        }
    }

    /**
     * find and change order
     * @param chars
     * @return
     */
    private boolean handle(char[] chars) {
        int n = chars.length;
        int i = n - 2;
        int j = n - 1;
        // 找到第一个chars[i] < chars[i+1]
        while (i >= 0 && chars[i] > chars[i+1]) {
            i--;
        }

        if (i == -1) {
            return false;
        }

        // 从右边开始找到第一个chars[j] > chars[i]
        while (j > i && chars[j] < chars[i]) {
            j--;
        }
        swrap(chars, i, j);
        reverse(chars, i+1, n-1);
        return true;
    }

    /**
     * reverse char array specify inter regional
     * @param chars
     * @param from
     * @param to
     */
    private void reverse(char[] chars, int from, int to) {
        while (from < to) {
            char temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        String str = "abcd";
        PermutationStr permutationStr = new PermutationStr();
//        permutationStr.permutationStrOne(str.toCharArray(), 0);
        permutationStr.permutationStrTwo(str.toCharArray());
    }

}
