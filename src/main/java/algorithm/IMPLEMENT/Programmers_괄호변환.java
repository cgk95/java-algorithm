package algorithm.IMPLEMENT;

import java.util.Stack;

public class Programmers_괄호변환 {
    public String solution(String w) {
        StringBuilder answer = new StringBuilder();
        if (w.isEmpty()) {
            return "";
        }
        if (checkCorrect(w)) {
            return w;
        }
        return make(w);
    }

    public String make(String uv) {
        if (uv.isEmpty()) {
            return uv;
        }
        String u = "";
        String v = "";
        for (int i = 1; i <= uv.length(); i++) {
            if (checkEqual(uv.substring(0, i))) {
                u = uv.substring(0, i);
                v = uv.substring(i);
                break;
            }
        }
        if (checkCorrect(u)) {
            return u + make(v);
        } else {
            return "(" + make(v) + ")" + reverse(u);
        }
    }

    public String reverse(String u) {
        u = u.substring(1, u.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : u.toCharArray()) {
            if (c == ')') {
                sb.append('(');
            } else if (c == '(') {
                sb.append(')');
            }
        }
        return sb.toString();
    }

    public boolean checkEqual(String u) {
        int countA = 0;
        int countB = 0;
        for (char c : u.toCharArray()) {
            if (c == '(') {
                countA++;
            } else if (c == ')') {
                countB++;
            }
        }
        return countB == countA;
    }

    public boolean checkCorrect(String u) {
        Stack<Character> stk = new Stack<>();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stk.push(c);
            } else if (c == ')') {
                if (stk.isEmpty()) {
                    return false;
                } else {
                    stk.pop();
                }
            }
        }
        return stk.isEmpty();
    }
}
