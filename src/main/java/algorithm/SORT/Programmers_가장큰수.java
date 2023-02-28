package algorithm.SORT;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Programmers_가장큰수 {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> {
                    int a = Integer.parseInt(o1 + o2);
                    int b = Integer.parseInt(o2 + o1);
                    return b - a;
                })
                .collect(Collectors.joining());
        return answer.charAt(0) == '0' ? "0" : answer;
    }

    public static void main(String[] arg) {
        Programmers_가장큰수 sol = new Programmers_가장큰수();
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));
    }
}
