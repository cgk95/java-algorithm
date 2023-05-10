package algorithm.DP;

public class Programmers_멀리뛰기 {
    public long solution(int n) {
        long[] answer = new long[2001];
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }
        return answer[n];
    }

    public static void main(String[] args) {
        Programmers_멀리뛰기 sol = new Programmers_멀리뛰기();
        System.out.println(sol.solution(4));
    }
}
