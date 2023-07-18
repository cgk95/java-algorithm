package algorithm.STRING;

// FIXME :: 테케 두 개 틀림. 알고리즘 보완 필요
public class Programmers_N진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder tube = new StringBuilder();
        StringBuilder game = new StringBuilder();
        int size = p + (t - 1) * m;
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

        tube.append(game.charAt(--p));
        while (p + m <= size) {
            tube.append(String.valueOf(game.charAt(p += m)).toUpperCase());
        }

        if (tube.length() != t) {
            System.out.println("필요한 정답 문자열의 크기와 다름 :: 오류발생");
        }
        return tube.toString();
    }

    public static void main(String[] args) {
        Programmers_N진수게임 sol = new Programmers_N진수게임();
        System.out.println(sol.solution(2, 4, 2, 1));
        System.out.println(sol.solution(2, 4, 2, 2));
        System.out.println(sol.solution(16, 16, 2, 1));
    }
}
