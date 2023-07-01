package algorithm.GRAPH;

// 인접행렬로 그래프 구현
public class GraphMatrix {
    char[] vertices; // 정점 저장용
    int[][] adjMat; // 근접 행렬 저장용
    int elementCount;

    public GraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elementCount = 0;
    }

    public boolean isFull() {
        return this.elementCount == this.vertices.length;
    }

    /**
     * 정점을 추가하는 메서드
     **/
    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("그래프가 꽉 찼음니닷!");
            return;
        }

        this.vertices[this.elementCount++] = data;
    }

    /**
     * 근접행렬에 표시하여 양방향 간선을 추가하는 메서드
     **/
    public void addEdge(int x, int y) {
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

    /**
     * 근접행렬에 표시하여 단방향 간선을 추가하는 메서드
     **/
    public void addDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 1;
    }

    public void deleteEdge(int x, int y) {
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    }

    /**
     * 근접행렬에 표시하여 단방향 간선을 제거하는 메서드
     **/
    public void deleteDirectedEdge(int x, int y) {
        this.adjMat[x][y] = 0;
    }

    public void printAdjacentMatrix() {
        System.out.print("  ");
        for (char item : this.vertices) {
            System.out.print(item + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elementCount; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elementCount; j++) {
                System.out.print(this.adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(4);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentMatrix();
    }

}
