package algorithm.STACK;

import java.util.Stack;

public class Programmers_짝지어제거하기 {
    public int solution(String s) {
        if (s.length() % 2 != 0) return 0;

        Stack<String> stk = new Stack<>();
        for (String word : s.split("")) {
            if (!stk.isEmpty() && stk.peek().equals(word)) {
                stk.pop();
                continue;
            }
            stk.push(word);
        }

        return !stk.isEmpty() ? 0 : 1;
    }
}
