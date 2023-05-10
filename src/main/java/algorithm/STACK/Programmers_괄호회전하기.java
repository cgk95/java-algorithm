package algorithm.STACK;

import java.util.*;

public class Programmers_괄호회전하기 {
    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for (String str : s.split("")) {
            q.offer(str);
        }
        while (!q.isEmpty() && len > 0) {
            q.offer(q.poll());
            len--;
            if (checkCondition(new ArrayList<>(q))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean checkCondition(List<String> list) {
        Stack<String> stk = new Stack<>();
        for (String s : list) {
            if (stk.isEmpty()) {
                if (s.equals("(") || s.equals("[") || s.equals("{")) {
                    stk.push(s);
                } else {
                    return false;
                }
            } else {
                String curr = stk.peek();
                if (curr.equals("(") && s.equals(")")) {
                    stk.pop();
                } else if (curr.equals("[") && s.equals("]")) {
                    stk.pop();
                } else if (curr.equals("{") && s.equals("}")) {
                    stk.pop();
                } else if (s.equals("(") || s.equals("[") || s.equals("{")) {
                    stk.push(s);
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {
        Programmers_괄호회전하기 sol = new Programmers_괄호회전하기();
        System.out.println(sol.solution("}]()[{"));
    }
}
