package com.lei.cc150;


public class Ch1_2 {
    /* using '#' as null to simulate C style string */
    public static void reverse(char[] chars) {
        char c;
        int i = chars.length - 1;
        int j = 0;
        while (j < i) {
            c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        char[] cs = new char[]{'a', 'b', 'c', 'd', 'f'};
        reverse(cs);
        for (char c : cs) {
            System.out.println(c);
        }
    }
}
