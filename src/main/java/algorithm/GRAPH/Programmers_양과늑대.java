package algorithm.GRAPH;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Programmers_양과늑대 {
    private int answer;
    private List<Edge>[] tree;
    private boolean[] visited;

    public int solution(int[] info, int[][] edges) {
        tree = new List[info.length];
        visited = new boolean[info.length];
        answer = 0;
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int[] e : edges) {
            tree[e[0]].add(new Edge(e[1]));
        }

        List<Integer> next = new ArrayList<>();
        for (Edge e : tree[0]) {
            next.add(e.ends);
        }

        myDfs(info, next, 0, 0, 0);
        return answer;
    }

    private void myDfs(int[] info, List<Integer> prev, int currIdx, int sheep, int wolf) {
        if (info[currIdx] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        if (sheep <= wolf) {
            return;
        }

        answer = Math.max(answer, sheep);

        List<Integer> next = new ArrayList<>(prev);
        for (Edge e : tree[currIdx]) {
            next.add(e.ends);
        }

        next.remove(Integer.valueOf(currIdx));

        for (int n : next) {
            if (!visited[n]) {
                visited[n] = true;
                myDfs(info, next, n, sheep, wolf);
                visited[n] = false;
            }
        }

    }

    public static class Edge {
        int ends;

        public Edge(int ends) {
            this.ends = ends;
        }
    }

}
