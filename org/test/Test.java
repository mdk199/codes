package org.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {
    //Given a binary tree find out a path that sum up to zero

    static Set<Node> path = new LinkedHashSet<>();

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(1);
        root.left.left = new Node(-1);
        root.right.right = new Node(-4);
        if (checkPathSum(root, 0)) {
            System.out.println(path);
        }
    }


    private static boolean checkPathSum(Node root, int currentSum) {
        if (root == null && currentSum == 0) {
            return true;
        } else if(root == null)
            return false;
        boolean lpath = checkPathSum(root.left, currentSum + root.value);
        boolean rpath = checkPathSum(root.right, currentSum + root.value);
        if (rpath) {
            path.add(root);
            return rpath;
        }
        if (lpath) {
            path.add(root);
            return lpath;
        }
        return false;
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
