package algorithm.SORT;

import java.util.Arrays;

public class Programmers_Hindex {
    public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed()
                .sorted((o1, o2) -> o2 - o1)
                .toArray(Integer[]::new);
        int answer = 0;
        int n = arr.length;
        while (n > 0) {
            int count = n;
            for (Integer value : arr) {
                if (value >= n) {
                    count--;
                }
            }
            if (count <= 0) {
                answer = n;
                break;
            }
            n--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Programmers_Hindex sol = new Programmers_Hindex();
        System.out.println(sol.solution(new int[]{25, 8, 5, 3, 3}));
    }
}
