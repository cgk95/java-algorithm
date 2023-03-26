package algorithm.STACK;

import java.util.Stack;

public class Programmers_문자열압축해제 {
    public String solution(String code) {
        String num = "";
        Stack<Integer> numberStk = new Stack<>();
        Stack<String> strStk = new Stack<>();
        boolean flag = false;
        for (String s : code.split("")) {
            if ("1234567890".contains(s)) {
                num += s;
                flag = true;
            } else {
                if (s.equals("}")) {
                    StringBuilder sb = new StringBuilder();
                    while (!strStk.peek().equals("{")) {
                        sb.append(strStk.pop());
                    }
                    strStk.pop(); // "{ " 빼내기

                    sb.reverse();
                    String sub = sb.toString();
                    strStk.push(sub.repeat(numberStk.pop()));
                } else {
                    strStk.push(s);
                }
            }
            if (flag) {
                numberStk.push(Integer.parseInt(num));
                num = "";
                flag = false;
            }

        }
        StringBuilder answer = new StringBuilder();
        for (String s : strStk) {
            answer.append(s);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Programmers_문자열압축해제 sol = new Programmers_문자열압축해제();
        System.out.println(sol.solution("5{he2{l}o}friend"));
        System.out.println(sol.solution("de2{afew}w3{rq5{f}}"));
    }
}
