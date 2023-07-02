package algorithm.STRING;

import java.util.Arrays;

public class Programmers_단어검색프로그램 {
    public int[] solution(String[] words, String[] queries) {
        // 준비
        int[] answer = new int[queries.length];
        // 로직 처리
        for (int i = 0; i < queries.length; i++) {
            String temp = queries[i].replace("*", "");
            if (queries[i].startsWith("*")) { // 단어의 끝 부분인 경우
                for (String target : words) {
                    if (target.endsWith(temp)) {
                        answer[i]++;
                    }
                }
            } else {                          // 단어의 처음 부분인 경우
                for (String target : words) {
                    if (target.startsWith(temp)) {
                        answer[i]++;
                    }
                }
            }
        }
        // 반환
        return answer;
    }

    public static void main(String[] args) {
        Programmers_단어검색프로그램 sol = new Programmers_단어검색프로그램();
        System.out.println(Arrays.toString(sol.solution(new String[]{"hello", "hell", "good", "goose", "children", "card", "teachable"}, new String[]{"hell*", "goo*", "*able", "qua*"})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"zero", "base", "students", "are", "the", "best"}, new String[]{"z*", "*e", "s*"})));
    }
}
