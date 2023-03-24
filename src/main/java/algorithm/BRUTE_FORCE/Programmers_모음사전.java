package algorithm.BRUTE_FORCE;

import java.util.ArrayList;

public class Programmers_모음사전 {
    String[] words;
    ArrayList<String> list = new ArrayList<>();
    boolean flag = false; // 정답 문자열에 도달하지 못함

    public int solution(String word) {
        words = new String[]{"A", "E", "I", "O", "U"};
        myRecursive("", 0);
        return list.indexOf(word) + 1; // 인덱스에다가 1을 더해야 n번째 문자열
    }

    private void myRecursive(String target, int depth) {
        if (!target.equals("")) {
            list.add(target);
        }
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < words.length; i++) {
            myRecursive(target + words[i], depth + 1);
        }
    }

    public static void main(String[] args) {
        Programmers_모음사전 sol = new Programmers_모음사전();
        System.out.println(sol.solution("AAAAE"));
        System.out.println(sol.solution("AAAE"));
        System.out.println(sol.solution("I"));
        System.out.println(sol.solution("EIO"));
    }
}
