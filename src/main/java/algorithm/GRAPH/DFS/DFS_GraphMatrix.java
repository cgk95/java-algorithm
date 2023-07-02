package algorithm.GRAPH.DFS;

import algorithm.GRAPH.GraphMatrix;

import java.util.Stack;

public class DFS_GraphMatrix extends GraphMatrix {
    public DFS_GraphMatrix(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elementCount];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            for (int i = this.elementCount - 1; i >= 0; i--) {
                if (this.adjMat[curId][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DFS_GraphMatrix graph = new DFS_GraphMatrix(7);
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
