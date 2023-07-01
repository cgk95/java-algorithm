package algorithm.BRUTE_FORCE;

public class Programmers_피로도 {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        for (int j = 1; j <= dungeons.length; j++) { // 몇개의 던전을 순회할 것인지
            myDfs(dungeons, 0, dungeons.length, j, k);
        }
        return answer;
    }

    private void myDfs(int[][] dungeons, int depth, int n, int r, int k) {
        if (depth == r || k <= 0) { // 목표한 갯수의 던전을 돌파했거나 피로도를 모두 소모했을 경우
            answer = Math.max(answer, depth);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 방문하지 않았고 최소요구 피로도보다 피로도가 많은 경우
                visited[i] = true;
                myDfs(dungeons, depth + 1, n, r, k - dungeons[i][1]);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Programmers_피로도 sol = new Programmers_피로도();
        System.out.println(sol.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}
