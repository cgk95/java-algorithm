package algorithm.HASH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_오픈채팅방 {
    HashMap<String, String> pkfk;

    public String[] solution(String[] record) {
        pkfk = new HashMap<>();
        List<String> answer = new ArrayList<>();
        // 닉네임 결정하기
        for (String s : record) {
            StringTokenizer input = new StringTokenizer(s);
            String op = input.nextToken();
            String userId = input.nextToken();
            switch (op) {
                case "Enter", "Change" -> pkfk.put(userId, input.nextToken());
            }
        }
        // 출력 만들기
        for (String s : record) {
            StringTokenizer input = new StringTokenizer(s);
            String op = input.nextToken();
            String userId = input.nextToken();
            switch (op) {
                case "Enter" -> answer.add(pkfk.get(userId) + "님이 들어왔습니다.");
                case "Leave" -> answer.add(pkfk.get(userId) + "님이 나갔습니다.");
            }
        }
        return answer.toArray(String[]::new);
    }
}
