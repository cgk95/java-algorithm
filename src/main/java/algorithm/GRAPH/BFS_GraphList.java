package algorithm.GRAPH;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_GraphList extends GraphList {
    public BFS_GraphList(int size) {
        super(size);
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elementCount];
        Queue<Integer> q = new LinkedList<>();

        q.offer(id);
        visited[id] = true;

        while (!q.isEmpty()) {
            int currId = q.poll();
            System.out.print(this.vertices[currId] + " ");

            Node curr = this.adjList[currId];
            while (curr != null) {
                if (!visited[curr.id]) {
                    q.offer(curr.id);
                    visited[curr.id] = true;
                }
                curr = curr.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        BFS_GraphList graph = new BFS_GraphList(7);
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
