package algorithm.String;

public class Programmers_애너그램 {
    public boolean solution(String s, String t) {
        //연산
        if (s.length() != t.length()) {
            return false;
        }
        // 배열 초기화
        int[] count = new int[128]; // 아스키코드 값의 범위는 0~127
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : t.toCharArray()) {
            if (count[c] == 0) {
                return false;
            }
            count[c]--;
        }
        return true;
    }

    public static void main(String[] args) {
        Programmers_애너그램 sol = new Programmers_애너그램();
        System.out.println(sol.solution(
                "imfinethankyou", "atfhinemnoyuki"));
    }
}
