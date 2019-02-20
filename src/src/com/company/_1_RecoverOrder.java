package com.company;

import com.sun.source.util.Trees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _1_RecoverOrder {

    /**
     * [3, 5, 1, 2, 4] -> [0, 1, 0, 1, 3] new number represents how many number on left are smaller.
     * Now recover the origin array
     * @param input
     * @return
     */
    public static int[] recoverOrder(int[] input) {
        int[] res = new int[input.length];
        TreeSet<Integer> visitedNums = new TreeSet<>();
        for (int i = input.length - 1; i >= 0; i--) {
            int start = input[i] + 1;
            for (int visitedNum : visitedNums) {
                if (visitedNum <= start) {
                    start++; // push to right until every visited num is greater
                } else break;
            }
            res[i] = start;
            visitedNums.add(res[i]);
        }
        return res;
    }

    // 要理解input[i] 的定义是什么： 前i个数中它的位置
    public static int[] recoverOrder1(int[] input) {
        int[] res = new int[input.length];
        List<Integer> remainNums = new ArrayList<>();
        for (int i = 1; i <= input.length; i++) {
            remainNums.add(i);
        }

        for (int i = input.length - 1; i >= 0; i--) {
            res[i] = remainNums.get(input[i]);
            remainNums.remove(input[i]);
        }
        return res;
    }

    /**
     * Java knowledge:
     * 1. TreeSet是无重复的ordered set, 默认从小到大排序
     * 2. Reverse排序快捷方式 new TreeSet(Collections.reverseOrder())
     * 3. For each loop 会从小到大遍历， 没有很好的方式直接从末端开始遍历
     * 4. 一般 类名s是util class包含convenient static method来生成相关的类instance
     */

    public static void main(String[] args) {
        int[] input = new int[] { 0, 1, 0, 1, 3 };
        for (int num : recoverOrder1(input)) {
            System.out.println(num);
        }
    }
}
