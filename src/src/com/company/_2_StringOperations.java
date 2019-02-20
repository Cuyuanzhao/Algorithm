package com.company;

import java.util.Arrays;

public class _2_StringOperations {
    public static void main(String[] args) {
//        testConstructor();
//        testSplit();
//        testReplace();
//        testJoin();
//        testIndexOf();
        testCompareTo();
    }

    public static void testConstructor() {
        String strFromCharArray = new String(new char[] { 'a', 'b', 'c' }); // "abc"
        System.out.println(strFromCharArray);
    }

    //---------------------------- 拆分 -------------------------
    /**
     * split(String regex)
     * split(String regex, int matchLimit)
     * 将string 根据regex来split成一个数组
     */
    public static void testSplit() {
        String str = "a1,a2,a4,a4";
        final String[] split = str.split(",");
    }

    //---------------------------- 合并 -------------------------
    /**
     * join(String delimiter, String...)
     * join(String delimiter, Iterable<? extend CharSequence> elements)
     * 将给定的一些String用分割符join成一个
     */
    public static void testJoin() {
        // "str1,str2"
        final String joinedStr = String.join(",", Arrays.asList("str1", "str2"));
        System.out.println(joinedStr);
    }

    //---------------------------- 替换 -------------------------
    /**
     * replace(char oldChar, char newChar)
     * 将string里面的某个char全部替换成新的
     * replaceAll(String regex, String replacement), replaceFirst(String regex, String replacement)
     * 将string里面match regex的subString替换成新的
     */
    public static void testReplace() {
        String str = "abXasX";
        str.replace('X', 'Y');  // "abYasY"
        str.replaceAll("a.", "BB");// "BBXBBX"
    }

    //---------------------------- 查找 -------------------------

    /**
     * indexOf(int targetChar)
     * indexOf(int targetChar, int startIdx)
     * indexOf(String targetStr)
     * indexOf(String targetStr, int startIdx)
     * lastIdxOf 就是从后往前找
     * 找到match的char或者string的index，找不到返回 -1
     *
     * startsWith(String prefex)
     * endsWith(String surfix)
     */
    public static void testIndexOf() {
        String str = "abXasXa";
        final int idx = str.indexOf('X'); // 2
        final int idx1 = str.indexOf('X', 3); // 5
        final int idx2 = str.indexOf("Xa"); // 2
        final int idx3 = str.indexOf("Xas", 3); // 5
        System.out.println(idx3);

    }

    //---------------------------- 比较 -------------------------
    public static void testCompareTo() {
        String str1 = "abc";
        String str2 = "Abc";
        final int res = str1.compareTo(str2);// > 0
        final int res1 = str1.compareToIgnoreCase(str2);// == 0
        System.out.println(res1);
    }

}
