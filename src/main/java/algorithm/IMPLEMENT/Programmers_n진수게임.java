package algorithm.IMPLEMENT;

public class Programmers_n진수게임 {
    public String solution(int n, int t, int m, int p) { // 진법, 구할 숫자의 개수, 참가인원, 튜브의 순서
        StringBuilder tube = new StringBuilder();
        StringBuilder game = new StringBuilder();
        int size = p + (t - 1) * m; //p + (t - 1) * m;
        int num = 0;

        while (game.length() < size) {
            String next = Integer.toString(num, n);
            if (next.length() + game.length() <= size) {
                game.append(next);
            } else {
                int cap = size - game.length();
                game.append(next, 0, cap);
            }
            num++;
        }

        tube.append(String.valueOf(game.charAt(--p)).toUpperCase());
        while (p + m <= size) {
            tube.append(String.valueOf(game.charAt(p += m)).toUpperCase());
        }

        if (tube.length() != t) {
            System.out.println("ERROR :: 필요한 정답 문자열의 크기와 다름");
        }

        return tube.toString();
    }


    public static void main(String[] args) {
        Programmers_n진수게임 sol = new Programmers_n진수게임();
        System.out.println(sol.solution(2, 4, 2, 1));
    }
}
