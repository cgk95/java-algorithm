package algorithm.STACK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class BOJ1918_후위표기식 {
    static HashMap<Character, Integer> priorMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> op = new Stack<>();
        StringBuilder answer = new StringBuilder();
        priorMap.put('*', 2);
        priorMap.put('/', 2);
        priorMap.put('+', 1);
        priorMap.put('-', 1);
        priorMap.put('(', 0);
        priorMap.put(')', 0);

        for (Character c : input.toCharArray()) {
            //-- 피연산자라면 바로 정답문자열에 추가 --//
            if (Character.isAlphabetic(c)) {
                answer.append(c);
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') { //-- 현재 연산자보다 스택의 연산자 우선순위가 높다면 --//
                while (!op.isEmpty() && priorMap.get(c) <= priorMap.get(op.peek())) {
                    answer.append(op.pop());
                }
                op.push(c);
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    answer.append(op.pop());
                }
                op.pop();
            }
        }
        //--  남은 거 쥐어짜기 --//
        while (!op.isEmpty()) {
            answer.append(op.pop());
        }
        //-- 출력 --//
        System.out.println(answer);
    }
}
