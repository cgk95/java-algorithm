package algorithm.IMPLEMENT;

import java.util.*;

public class 문자열수식계산 {
    private static final HashMap<String, Integer> operator = new HashMap<>();
    private static Stack<String> operationStack;
    private static ArrayList<String> postfix;
    public 문자열수식계산(){
        operationStack = new Stack<>();
        postfix = new ArrayList<>();
        setOperator();
    }
    public double solution(String S) {
        toPostFixedExpression(getParsedString(S));
        doPostfixOperation();
        double answer=Double.parseDouble(operationStack.pop());
        return Math.round(answer*100)/100.0;
    }

    private static void doPostfixOperation() {
        for(String s: postfix){
            if (!"+-/*?".contains(s)) {
                operationStack.push(s);
            } else {
                double b=Double.parseDouble(operationStack.pop());
                double a=Double.parseDouble(operationStack.pop());
                if (s.equals("*")) {
                    operationStack.push(String.valueOf(a*b));
                    continue;
                }
                if(s.equals("/") && b!=0){
                    operationStack.push(String.valueOf(a/b));
                    continue;
                }
                if(s.equals("+")){
                    operationStack.push(String.valueOf(a + b));
                    continue;
                }
                if (s.equals("-")) {
                    operationStack.push(String.valueOf(a - b));
                }
            }
        }
    }

    private static void toPostFixedExpression(String[] parsedString) {
        for (String s : parsedString) {
            if (!"+-/*?".contains(s)) {
                postfix.add(s);
                continue;
            }
            if (s.equals("(")) {
                operationStack.push(s);
                continue;
            }
            if (s.equals(")")) {
                while (!operationStack.peek().equals("(")) {
                    postfix.add(operationStack.pop());
                }
                operationStack.pop();
                continue;
            }
            if (operator.containsKey(s)) { // 괄호가 아닌 연산자의 경우
                while (operationStack.size() > 0 && operator.get(s) <= operator.get(operationStack.peek())) {
                    postfix.add(operationStack.pop());
                }
                operationStack.push(s);
            }
        }
        while(!operationStack.isEmpty()){
            postfix.add(operationStack.pop());
        }
    }

    private static String[] getParsedString(String S) {
        return Arrays.stream(S.replaceAll("[+]", " + ")
                        .replaceAll("-", " - ")
                        .replaceAll("[*]", " * ")
                        .replaceAll("/", " / ")
                        .split(" "))
                .toArray(String[]::new);
    }

    private static void setOperator() {
        operator.put("+", 2);
        operator.put("-", 2);
        operator.put("*", 3);
        operator.put("/", 3);
        operator.put("(", 1);
    }

}
