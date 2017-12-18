package com.uptowncat.string;

/**
 * Created by UpTownCat on 2017/12/18.
 * 判断字符串a是否包含b
 */
public class ContainStr {
    /**
     * 将字符串a和b一个一个比较
     * @param a
     * @param b
     * @return
     */
    public boolean solutionOne(String a, String b) {
        if(a == b) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        for(int i = 0; i < b.length(); i++) {
            char cur = b.charAt(i);
            for(int j = 0; j < a.length(); j++) {
                char compare = a.charAt(j);
                if(cur == compare) {
                    break;
                }else {
                    if(j == a.length() -1 && cur != compare) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 计算素数连城的值
     * @param a
     * @param b
     * @return
     */
    public boolean solutionTwo(String a, String b) {
        if(a == b) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        String[] tags = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101".split(" ");
        long resA = 1;
        long resB = 1;

        for(int i = 0; i < a.length(); i++) {
            int index = a.charAt(i) - 'a';
            resA *= Integer.parseInt(tags[index]);
        }

        for(int i = 0; i < b.length(); i++) {
            int index = b.charAt(i) - 'a';
            resB *= Integer.parseInt(tags[index]);
        }
        return resA % resB == 0;
    }

    /**
     * 用26位整数记录字符的出现记录
     * @param a
     * @param b
     * @return
     */
    public boolean solutionThree(String a, String b) {
        if(a == b) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        int record = 0;
        for(int i = 0; i < a.length(); i++) {
            record |= (1 << (a.charAt(i) - 'a'));
        }
        for(int i = 0; i < b.length(); i++) {
            if((record & (1 << (b.charAt(i) - 'a'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ContainStr containStr = new ContainStr();
        String a = "abcd";
        String b = "bae";
        System.out.println(containStr.solutionOne(a, b));
        System.out.println(containStr.solutionTwo(a, b));
        System.out.println(containStr.solutionThree(a, b));
    }
}
