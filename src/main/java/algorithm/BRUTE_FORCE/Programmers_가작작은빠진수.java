package algorithm.BRUTE_FORCE;

import java.util.Arrays;

public class Programmers_가작작은빠진수 {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int pvt= numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (pvt + 1 != numbers[i]) {
                return pvt+1;
            }
            pvt++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Programmers_가작작은빠진수 sol = new Programmers_가작작은빠진수();
        System.out.println(sol.solution(new int[]{9, 4, 2, 3, 7, 5}));
        System.out.println(sol.solution(new int[]{26, 62, 34, 52, 15, 17, 16, 20, 19, 18}));
    }
}

