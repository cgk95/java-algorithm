package algorithm.BIT;

public class Programmers_다음큰숫자 {
    public int solution(int n) {
        int target = Integer.bitCount(n);
        int x = 1;
        while (true) {
            if ((x & n) == x) { // 가장 작은 1 찾아내기
                break;
            }
            x = x << 1;
        }

        n += x;
        target -= Integer.bitCount(n);

        // 모자란 1 개수만큼 오른쪽에 채워넣기
        int y = 1;
        while (target > 0) {
            if ((n & y) == 0) {
                n += y;
            }
            y = y << 1;
            target--;
        }

        return n;
    }


    public static void main(String[] args) {
        Programmers_다음큰숫자 sol = new Programmers_다음큰숫자();
        System.out.println(sol.solution(78));
        System.out.println(sol.solution(15));
    }
}
