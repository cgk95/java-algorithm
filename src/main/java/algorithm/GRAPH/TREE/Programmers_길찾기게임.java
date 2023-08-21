package algorithm.GRAPH.TREE;

import java.util.ArrayList;
import java.util.Arrays;


public class Programmers_길찾기게임 {
    Node root;

    int[][] answer;
    ArrayList<Integer> order;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        answer = new int[2][];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (o1, o2) -> o2.level - o1.level);
        root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        order = new ArrayList<>();
        preOrder(root);
        answer[0] = order.stream().mapToInt(Integer::intValue).toArray();

        order = new ArrayList<>();
        postOrder(root);
        answer[1] = order.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static class Node {
        int nodeNum;
        int pos, level;
        Node left;
        Node right;

        public Node(int nodeNum, int pos, int level) {
            this.nodeNum = nodeNum;
            this.pos = pos;
            this.level = level;
            this.left = null;
            this.right = null;
        }
    }

    public void insertNode(Node parent, Node curr) {
        if (parent.level > curr.level) { // 현재 노드의 부모일 가능성이 있을 때
            if (curr.pos < parent.pos) {
                if (parent.left != null) {
                    insertNode(parent.left, curr);
                } else {
                    parent.left = curr;
                }
            } else if (curr.pos > parent.pos) {
                if (parent.right != null) {
                    insertNode(parent.right, curr);
                } else {
                    parent.right = curr;
                }
            }
        } else { // 현재 노드의 자식일 가능성이 있을 때
            if (parent.pos < curr.pos) {
                if (curr.left != null) {
                    insertNode(curr.left, parent);
                } else {
                    curr.left = parent;
                }
            } else if (parent.pos > curr.pos) {
                if (curr.right != null) {
                    insertNode(curr.right, parent);
                } else {
                    curr.right = parent;
                }
            }
        }
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        order.add(node.nodeNum);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        order.add(node.nodeNum);
    }


}
