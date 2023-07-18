package algorithm.STACK;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Programmers_주식가격 {
    public int[] solution(int[] prices) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int price : prices) {
            q.add(price);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            int count = 0;
            for (int i : q) {
                if (i >= curr) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Programmers_주식가격 sol = new Programmers_주식가격();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
    }
}
