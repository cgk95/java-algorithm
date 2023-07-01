package algorithm.GRAPH.DFS_BFS;

import algorithm.GRAPH.GraphMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_GraphMatrix extends GraphMatrix {
    public BFS_GraphMatrix(int size) {
        super(size);
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elementCount];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elementCount - 1; i >= 0; i--) {
                if (this.adjMat[curId][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS_GraphMatrix graph = new BFS_GraphMatrix(7);
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.bfs(0);
    }
}
