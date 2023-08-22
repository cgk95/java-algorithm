package algorithm.GRAPH.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1068_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parent = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int deletedNode = Integer.parseInt(br.readLine());
        parent[deletedNode] = -2;
        propagateStatus(parent, deletedNode);

        int answer = 0;
        for (int nodeNum = 0; nodeNum < N; nodeNum++) {
            boolean isLeaf = true;
            if (parent[nodeNum] == -2) {
                continue;
            }
            for (int p : parent) {
                if (p == nodeNum) { // 자신을 부모로 하는 노드가 하나라도 있다면 리프노드가 아님
                    isLeaf = false;
                    break;
                }
            }
            if (isLeaf) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void propagateStatus(int[] parent, int deletedNode) {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == deletedNode) {
                parent[i] = -2;
                propagateStatus(parent, i);
            }
        }
    }
}
