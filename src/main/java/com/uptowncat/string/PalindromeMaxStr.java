package com.uptowncat.string;

public class PalindromeMaxStr {

    /**
     * find the longest palindrome str
     * time O(n*n)
     * @param str
     * @return
     */
    public String getMaxPalindromeStrOne (String str) {
        if ((str == null) || str.length() == 0) {
            return str;
        }
        String maxStr = String.valueOf(str.charAt(0));
        for (int i = 0; i < str.length(); i++) {
            String oddStr = getPalindromeStr(str, i-1, i+1, maxStr.length());
            String evenStr = getPalindromeStr(str, i, i+1, maxStr.length());
            if (oddStr != null && oddStr.length() > maxStr.length()) {
                maxStr = oddStr;
            }
            if (evenStr != null && evenStr.length() > maxStr.length()) {
                maxStr = evenStr;
            }
        }
        return maxStr;
    }

    /**
     * 获取回文串
     * @param str
     * @param left
     * @param right
     * @param maxLen
     * @return
     */
    private String getPalindromeStr (String str, int left, int right, int maxLen) {
        int sub = right - left == 1 ? 0 : 1;
        while (left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen <= right-left-sub)
            return str.substring(left+1, right);
        return null;
    }

    /**
     * find the max palindrome str
     * @param str
     * @return
     */
    public String getMaxPalindromeStrTwo (String str) {
        str = processStr(str);
        int[] p = new int[str.length()];
        int id = 0;
        int mx = 0;
        int start = 0;
        int maxLen = 0;
        for (int i = 1; i < str.length() - 1; i++) {
            if (mx - i > 0) {
                p[i] = Math.min(p[id*2 - i], mx-i);
            }
            int left = i - p[i] - 1;
            int right = i + p[i] + 1;
            while (left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
                p[i]++;
            }
            if (maxLen <= (right - left - 1)) {
                maxLen = right - left - 1;
                start = left + 1;
            }
            if (mx < right - 1) {
                mx = right - 1;
                id = i;
            }
        }
        return unProcessStr(str.substring(start, maxLen+2));
    }

    /**
     * process str abc to $#a#b#c#^
     * @param str
     * @return
     */
    private String processStr(String str) {
        StringBuffer sb = new StringBuffer("$#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)+"#");
        }
        sb.append("^");
        return sb.toString();
    }

    /**
     * un process str $#a#b#c#^ to abc
     * @param str
     * @return
     */
    private String unProcessStr(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#' && str.charAt(i) != '$' && str.charAt(i) != '^') {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PalindromeMaxStr palindromeMaxStr = new PalindromeMaxStr();
        String str = "babcbabcbaccba";
        System.out.println(palindromeMaxStr.getMaxPalindromeStrOne(str));
        System.out.println(palindromeMaxStr.getMaxPalindromeStrTwo(str));
    }
}
