package algorithm.STACK;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stk.isEmpty()) {
                stk.push(i);
                continue;
            }

            int prev = numbers[stk.peek()];
            int curr = numbers[i];

            if (prev >= curr) {
                stk.push(i);
                continue;
            }

            while (prev < curr) {
                answer[stk.pop()] = curr;
                if (!stk.isEmpty()) {
                    prev = numbers[stk.peek()];
                } else {
                    break;
                }
            }
            stk.push(i);

        }
        return answer;
    }
}
