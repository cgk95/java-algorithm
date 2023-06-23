package algorithm.TREE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639_이진검색트리 {
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));
        String input;

        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            insertNode(root, Integer.parseInt(input));
        }
        postOrder(root);
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void insertNode(Node parent, int curr) {
        if (parent.value > curr) {
            if (parent.left != null) {
                insertNode(parent.left, curr);
            } else {
                parent.left = new Node(curr);
            }
        } else if (parent.value < curr) {
            if (parent.right != null) {
                insertNode(parent.right, curr);
            } else {
                parent.right = new Node(curr);
            }
        }
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
