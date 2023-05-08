package algorithm.BINARY_SEARCH;

import java.util.Arrays;

public class Programmers_입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 가장 빠른 심사관이 처음에 들어갈 수 있도록 정렬

        long left = times[0];
        long right = (long) times[times.length - 1] * n;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int t : times) {
                sum += mid / t;
            }
            if (sum >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Programmers_입국심사 sol = new Programmers_입국심사();
        System.out.println(sol.solution(6, new int[]{7, 10})); // 28
        System.out.println(sol.solution(6, new int[]{10, 1})); // 6
        System.out.println(sol.solution(6, new int[]{2, 5})); // 10
    }
}
