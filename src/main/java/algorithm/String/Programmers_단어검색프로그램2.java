package algorithm.String;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_단어검색프로그램2 {
    public String[][] solution(String[] words, String[] queries) {
        // 준비
        String[][] answer = new String[queries.length][];
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            table.add(new ArrayList<>());
        }
        //로직처리
        for (int i = 0; i < queries.length; i++) {
            String target = queries[i];
            int length = target.length();
            String temp = target.replace("?", "");
            for (String word : words) {
                if (word.startsWith(temp) && word.length() == length) {
                    table.get(i).add(word);
                }
            }
            answer[i] = table.get(i).toArray(new String[0]);
        }
        //반환
        return answer;
    }

    public static void main(String[] args) {
        Programmers_단어검색프로그램2 sol = new Programmers_단어검색프로그램2();
        System.out.println(Arrays.
                deepToString(sol.
                        solution(new String[]{"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"},
                                new String[]{"he??", "g???", "childre?", "goo????", "?"})));
    }
}
