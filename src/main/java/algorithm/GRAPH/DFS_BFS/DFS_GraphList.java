package algorithm.GRAPH.DFS_BFS;

import algorithm.GRAPH.GraphList;

import java.util.Stack;

public class DFS_GraphList extends GraphList {
    public DFS_GraphList(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elementCount];
        Stack<Integer> stk = new Stack<>();

        stk.push(id);
        visited[id] = true;

        while (!stk.isEmpty()) {
            int currId = stk.pop();
            System.out.print(this.vertices[currId] + " ");

            Node curr = this.adjList[currId];
            while (curr != null) {
                if (!visited[curr.id]) {
                    stk.push(curr.id);
                    visited[curr.id] = true;
                }
                curr = curr.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        DFS_GraphList graph = new DFS_GraphList(7);
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

        graph.dfs(0);
    }
}
