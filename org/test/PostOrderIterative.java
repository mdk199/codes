package org.test;

import java.util.Objects;
import java.util.Stack;

public class PostOrderIterative {
    // Given a node root print post order in iterative
    static Stack<Node> stack = new Stack<>();
    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node (3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // 4 5 2 3 1
        printPostOrder(root);
    }

    private static void printPostOrder(Node root){
        if(root == null)
            return;
        Node flag = new Node(-1);
        if(Objects.nonNull(root))
            stack.push(root);
        while(!stack.isEmpty()) {
            Node temp = stack.pop();
            if(temp.equals(flag)) {
                System.out.println(stack.peek().value);
                stack.pop();
            }
            else {
                stack.push(temp);
                stack.push(flag);
                if (Objects.nonNull(temp.right))
                    stack.push(temp.right);
                if (Objects.nonNull(temp.left))
                    stack.push(temp.left);
            }
        }
    }
}

class Node{

    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}
