package algorithm.BIT;

public class Programmers_점프와순간이동 {
    public int solution(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Programmers_점프와순간이동 sol = new Programmers_점프와순간이동();
        System.out.println(sol.solution(6));
    }
}
