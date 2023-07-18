package algorithm.HASH;

import java.util.HashMap;

public class Programmers_폰켓몬 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> phoneKetMon = new HashMap<>();
        int numberToChoose = nums.length / 2;
        for (int type : nums) {
            phoneKetMon.computeIfPresent(type, (k, v) -> v + 1);
            phoneKetMon.putIfAbsent(type, 1);
        }
        // key의 개수가 numberTochoose 보다 많은 경우와 적은 경우로 나눠서 연산
        return Math.min(phoneKetMon.size(), numberToChoose);
    }

}
