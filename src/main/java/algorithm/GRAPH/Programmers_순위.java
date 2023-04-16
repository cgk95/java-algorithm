package algorithm.GRAPH;

import java.util.ArrayList;

public class Programmers_순위 {
    ArrayList<Node> nodes = new ArrayList<>();

    public int solution(int n, int[][] results) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
        for (int[] match : results) {
            int winner = match[0], loser = match[1];
            nodes.get(winner - 1).winList.add(loser);
            nodes.get(winner - 1).matchCount++;
            nodes.get(loser - 1).matchCount++;
        }
        for (int i = 0; i < nodes.size(); i++) {
            int size = nodes.get(i).winList.size();
            for (int j = 0; j < size; j++) {
                for (int[] match : results) {
                    if (match[0] == nodes.get(i).winList.get(j)) {
                        nodes.get(i).winList.add(match[0]);
                        if (nodes.get(i).matchCount < n - 1) {
                            nodes.get(i).matchCount++;
                        }
                    }
                }
            }
        }
        nodes.sort(Node::compareTo);
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).matchCount != n - 1) {
                break;
            }
            answer++;
        }
        return answer;
    }

    public class Node implements Comparable<Node> {
        int name;
        int matchCount = 0;
        ArrayList<Integer> winList = new ArrayList<>();

        public Node(int name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node other) {
            return other.matchCount - this.matchCount;
        }
    }

}
