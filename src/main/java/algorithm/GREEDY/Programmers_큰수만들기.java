package algorithm.GREEDY;

public class Programmers_큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int targetLength = number.length() - k;
        int start = 0; // 검사할 왼쪽 문자열의 시작 인덱스
        while (start < number.length() && sb.length() != targetLength) {
            int left = sb.length() + k + 1; // 검사할 왼쪽 문자열의 끝 인덱스
            int max = 0;
            for (int i = start; i < left; i++) {
                if (max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    start = i + 1; // 시작 지점 갱신
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Programmers_큰수만들기 sol = new Programmers_큰수만들기();
        System.out.println(sol.solution("1924", 2));
        System.out.println(sol.solution("1231234", 3));
        System.out.println(sol.solution("4177252841", 4));
    }
}
