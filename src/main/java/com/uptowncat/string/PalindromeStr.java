package com.uptowncat.string;

/**
 * Created by UpTownCat on 2017/12/18.
 */
public class PalindromeStr {
    /**
     * 从两头比较
     * @param str
     * @return
     */
    public boolean solutionOne(String str) {
        if(str == null || str == "") {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 从中间向两边判断
     * @param str
     * @return
     */
    public boolean solutionTwo(String str) {

        if(str == null || str == "") {
            return true;
        }
        int middle = (str.length() >> 1) - 1 >= 0 ? (str.length() >> 1) - 1 : 0;
        int left = middle;
        int right = str.length() - middle - 1;
        while (left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeStr palindromeStr = new PalindromeStr();
        String str1 = "abccba";
        String str2 = "dddkfd";
        System.out.println(palindromeStr.solutionOne(str1));
        System.out.println(palindromeStr.solutionTwo(str1));
        System.out.println(palindromeStr.solutionOne(str2));
        System.out.println(palindromeStr.solutionTwo(str2));
    }
}
