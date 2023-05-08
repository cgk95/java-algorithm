package algorithm.IMPLEMENT;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_노래제목 {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        // 준비
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        String[][] answer = new String[problems.length][];
        for (int i = 0; i < problems.length; i++) {
            table.add(new ArrayList<>());
        }
        // 로직 처리
        for (int k = 0; k < problems.length; k++) {
            for (int i = 0; i < lyrics.length; i++) {
                if (lyrics[i].startsWith(problems[k])) {
                    table.get(k).add(titles[i]);
                }
            }
            answer[k] = table.get(k).toArray(new String[0]);
        }
        // 출력
        return answer;
    }

    public static void main(String[] args) {
        Programmers_노래제목 sol = new Programmers_노래제목();
        System.out.println(Arrays.deepToString(sol.
                solution(new String[]{"아모르파티", "아기상어", "올챙이와개구리", "산다는건"},
                        new String[]{"산다는게다그런거지누구나빈손으로와...(후략)", "아기상어뚜루루뚜루귀여운뚜루루뚜루...(후략)", "개울가에올챙이한마리꼬물꼬물헤엄치다...(후략)", "산다는건다그런거래요힘들고아픈날도많지만...(후략)"},
                        new String[]{"산다", "아기상어", "올챙이"})));
    }
}
