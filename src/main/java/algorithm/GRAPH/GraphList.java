package algorithm.GRAPH;

public class GraphList {
    protected static class Node {
        public int id;
        public Node next;

        public Node(int id, Node next) {
            this.id = id;
            this.next = next;
        }
    }

    protected char[] vertices;
    protected Node[] adjList;
    protected int elementCount;


    public GraphList(int size) {
        this.vertices = new char[size];
        this.adjList = new Node[size];
        this.elementCount = 0;
    }

    public boolean isFull() {
        return this.elementCount == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is full!");
            return;
        }

        this.vertices[elementCount++] = data;
    }

    public void addEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
        this.adjList[y] = new Node(x, this.adjList[y]);
    }

    public void addDirectedEdge(int x, int y) {
        this.adjList[x] = new Node(y, this.adjList[x]);
    }

    public void printAdjacentList() {
        for (int i = 0; i < this.elementCount; i++) {
            System.out.print(this.vertices[i] + ": ");

            Node cur = this.adjList[i];
            while (cur != null) {
                System.out.print(this.vertices[cur.id] + " ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printAdjacentList();
    }
}

