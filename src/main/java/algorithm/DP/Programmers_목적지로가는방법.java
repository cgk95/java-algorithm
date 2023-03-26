package algorithm.DP;

public class Programmers_목적지로가는방법 {
    public int solution(int n, int k) {
        long[] dp = new long[n];
        int[] K = new int[k];

        for (int i = 0; i < k; i++) {
            K[i] = i + 1;
        }
        dp[0] = 1;
        int past = -1;
        for (int i = 1; i < n; i++) {
            for (int dist = 1; dist <= k; dist++) {
                if (i - dist >= 0 && past != dist) { // 범위에 벗어나지 않고, 이전에 이동한 거리와 겹치지 않으면
                    dp[i] += dp[i - dist];
                    dp[i] %= 1000000007;
                    past = dist;
                }
            }
        }
        return (int) (dp[n - 1]);
    }

    public static void main(String[] args) {
        Programmers_목적지로가는방법 sol = new Programmers_목적지로가는방법();
        System.out.println(sol.solution(5, 3));
    }
}
