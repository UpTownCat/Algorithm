package com.uptowncat.array;

import java.util.Arrays;

/**
 * Created by shiwang.xie on 2018/3/16.
 */
public class Zigzag {

    private int intToZigzag(int n) {
        return (n << 1) ^ (n >> 31);
    }

    private int zigzagToInt(int n) {
        return (n >> 1) ^ -(n & 1);
    }

    private int writeToBuffer(int n, byte[] bytes, int start) {
        int i = 0;
        for (; i < bytes.length; i++) {
            if ((n & ~0x7F) == 0) {
                bytes[i] = (byte)n;
                break;
            }else {
                bytes[i] = (byte)((n & 0x7F) | 0x80);
                n >>= 7;
            }
        }
        return start+i;
    }

    private int readToBuffer(byte[] bytes) {
        int n = 0;
        int offset = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte tmp = bytes[i];
            if ((tmp & 0x80) != 0x80) {
                n |= (tmp << offset);
                break;
            }else {
                n |= ((tmp & 0x7F) << offset);
            }
            offset += 7;
        }
        return zigzagToInt(n);
    }

    public static void main(String[] args) {
        Zigzag zigzag = new Zigzag();
        int n = -1;
        int zigzagInt = zigzag.intToZigzag(n);
        System.out.println("zigzag int is: " + zigzagInt);
        int intZigzag = zigzag.zigzagToInt(zigzagInt);
        System.out.println("int zigzag is: " + intZigzag);
        byte[] bytes = new byte[5];
        int len = zigzag.writeToBuffer(zigzagInt, bytes, 0);
        System.out.println("buffer len is: " + len);
        System.out.println("buffer array is: " + Arrays.toString(bytes));
        int result = zigzag.readToBuffer(bytes);
        System.out.println("result: " + result);
    }
}
