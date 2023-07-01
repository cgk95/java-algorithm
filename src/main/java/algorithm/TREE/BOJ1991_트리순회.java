package algorithm.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// TODO :: 다시 풀어보기
public class BOJ1991_트리순회 {
    static Node head = new Node('A', null, null);

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char curr = st.nextToken().charAt(0);
                char left = st.nextToken().charAt(0);
                char right = st.nextToken().charAt(0);
                insertNode(head, curr, left, right);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            preOrder(head);
            System.out.println();
            inOrder(head);
            System.out.println();
            postOrder(head);
        }
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.value = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node parent, char curr, char left, char right) {
        if (parent.value == curr) {
            parent.left = (left == '.' ? null : new Node(left, null, null));
            parent.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (parent.left != null) {
                insertNode(parent.left, curr, left, right);
            }
            if (parent.right != null) {
                insertNode(parent.right, curr, left, right);
            }
        }
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }


}
