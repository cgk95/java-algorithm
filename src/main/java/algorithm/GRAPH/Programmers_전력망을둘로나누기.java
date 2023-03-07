package algorithm.GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_전력망을둘로나누기 {
    ArrayList<ArrayList<Integer>> graph;
    int answer= Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        setGraph(n, wires);

        for (int[] arr : wires) {
            int a = arr[0];
            int b = arr[1];
            deleteAndRepairGraph(a, b);
        }
        return answer;
    }

    private void deleteAndRepairGraph(int a, int b) {
        graph.get(a).set(b, 0);
        graph.get(b).set(a, 0);
        int aside=myBFS(graph);
        answer=Math.min(Math.abs(graph.size()-1-2*aside),answer);
        graph.get(a).set(b, 1);
        graph.get(b).set(a, 1);
    }

    private int myBFS(ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited= new boolean[graph.size()];
        Loop1 :
        for (int i = 1; i<graph.size(); i++) {
            for (int j = 1; j < graph.size(); j++) {
                if (graph.get(i).get(j) == 1) {
                    q.offer(i);
                    break Loop1;
                }
            }
        }
        int count=0;
        while (!q.isEmpty()) {
            int curr=q.poll();
            visited[curr]=true;
            count++;
            for (int k=1;k<graph.size();k++) {
                if (graph.get(curr).get(k) == 1 && !visited[k]) {
                    q.offer(k);
                }
            }
        }
        return count;
    }

    private void setGraph(int n, int[][] wires) {
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < n + 1; j++) {
                graph.get(i).add(0);
            }
        }
        for (int[] arr : wires) {
            int a = arr[0];
            int b = arr[1];
            graph.get(a).set(b, 1);
            graph.get(b).set(a, 1);
        }
    }

    public static void main(String[] args) {
        Programmers_전력망을둘로나누기 sol = new Programmers_전력망을둘로나누기();
        System.out.println(sol.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }
}
