package algorithm.GREEDY;

import java.util.Arrays;

public class Programmers_제로지니어스 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Programmers_제로지니어스 sol = new Programmers_제로지니어스();
        System.out.println(sol.solution(new int[] {9, 5, 34, 3, 30}));
        System.out.println(sol.solution(new int[] {6, 2, 10}));
    }
}
