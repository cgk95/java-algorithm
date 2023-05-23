package algorithm.HASH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Programmers_압축 {
    static HashMap<String, Integer> map;
    static ArrayList<Integer> answer;
    static int count;

    public int[] solution(String msg) {
        map = new HashMap<>();
        count = 0;
        for (int i = 65; i < 91; i++) {
            map.putIfAbsent(String.valueOf((char) i), ++count);
        }

        answer = new ArrayList<>();
        int s = 0;
        while (s < msg.length()) {
            String prev = "";
            for (int i = s + 1; i <= msg.length(); i++) { // exclusive
                String subString = msg.substring(s, i);
                if (!map.containsKey(subString)) { // 이전 문자열은 가지고 있으나 다음 문자열을 가지고 있지 않은 경우
                    answer.add(map.get(prev));
                    map.put(subString, ++count);
                    s += prev.length();
                    break;
                } else { // 해당 문자열을 가지고 있는 경우
                    prev = subString;
                    if (i == msg.length()) {
                        answer.add(map.get(prev));
                        s += prev.length();
                        break;
                    }
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Programmers_압축 sol = new Programmers_압축();
        System.out.println(Arrays.toString(sol.solution("KAKAO")));
        System.out.println(Arrays.toString(sol.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(sol.solution("ABABABABABABABAB")));
    }
}
