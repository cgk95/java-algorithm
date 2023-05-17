package algorithm.MATH;

import java.util.Arrays;

public class Programmers_n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.max((int) (left % n + 1), (int) (left / n + 1));
            left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_n2배열자르기 sol = new Programmers_n2배열자르기();
        System.out.println(Arrays.toString(sol.solution(3, 2, 5)));
    }
}
