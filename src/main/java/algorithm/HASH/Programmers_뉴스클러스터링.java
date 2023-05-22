package algorithm.HASH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Programmers_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if (str1.equals(str2)) { // 아예 같으면
            return 65536;
        }
        List<String> set01 = makeSet(str1);
        List<String> set02 = makeSet(str2);
        Collections.sort(set01);
        Collections.sort(set02);

        // 교집합
        ArrayList<String> interSection = new ArrayList<>(makeInterSection(set01, set02));
        // 합집합
        set01.addAll(set02);
        for (String s : interSection) {
            set01.remove(s);
        }

        return (int) Math.floor(65536 * (double) interSection.size() / set01.size());
    }

    private List<String> makeSet(String target) {
        final int size = 2;
        ArrayList<String> subStr = new ArrayList<>();
        for (int i = 0; i < target.length() - 1; i++) {
            String element = target.substring(i, i + size);
            if (checkValidString(element)) {
                subStr.add(element);
            }
        }
        return subStr;
    }

    private boolean checkValidString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private List<String> makeInterSection(List<String> set01, List<String> set02) {
        ArrayList<String> interSection = new ArrayList<>();
        HashMap<String, Integer> hashMap02 = makeHashMap(set02);
        for (String s : set01) {
            if (hashMap02.containsKey(s) && hashMap02.get(s) > 0) {
                interSection.add(s);
                hashMap02.computeIfPresent(s, (k, v) -> v - 1);
            }
        }
        return interSection;
    }

    private HashMap<String, Integer> makeHashMap(List<String> set) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : set) {
            map.computeIfPresent(s, (k, v) -> v + 1);
            map.putIfAbsent(s, 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Programmers_뉴스클러스터링 sol = new Programmers_뉴스클러스터링();
        System.out.println(sol.solution("FRANCE", "french"));
        System.out.println(sol.solution("handshake", "shake hands"));
        System.out.println(sol.solution("aa1+aa2", "AAAA12"));
        System.out.println(sol.solution("E=M*C^2", "e=m*c^2"));

        System.out.println(sol.solution("abab", "baba")); // ab, ba, ab :: ba, ab, ba >> ab, ba :: ab,ba,ab,ba
    }
}
