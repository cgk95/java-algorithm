package algorithm.GREEDY;

import java.util.Arrays;
import java.util.Comparator;

public class Programmers_섬연결하기 {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        int answer = 0;
        // 자기 자신을 부모로 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2])); // 최소 비용의 간선들이 먼저 연결되도록
        for (int[] info : costs) {
            int start = info[0], end = info[1], cost = info[2];
            if (findParent(parent, start) != findParent(parent, end)) { // 연결되어 있는 노드인데, 부모가 다르면(아직 서클에 안들어왔으면)
                unionParent(parent, start, end);
                answer += cost;
            } // 이미 연결된 조팝들은 신경쓰지 않는다.
        }
        return answer;
    }

    private int findParent(int[] parent, int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a]=findParent(parent, parent[a]); // 메모이제이션
    }

    private void unionParent(int[] parent, int a, int b) {
        a = parent[a];
        b = parent[b];
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
