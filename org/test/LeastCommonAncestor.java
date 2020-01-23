package org.test;


public class LeastCommonAncestor {

  static Node BASE = new Node(4);

  public static void main(String[] args) {
    Node root = new Node(4);
    root.left = new Node(5);
    root.right = new Node(7);
    root.left.left = new Node(8);
    root.left.left.left = new Node(9);
    root.left.left.right = new Node(10);
    root.right.left = new Node(11);
    root.right.right = new Node(12);
    root.left.right = new Node(13);
    root.left.right.right = new Node(14);
    System.out.println(findLCS(root, new Node(8), new Node(10)));
  }

  public static Node findLCS(Node root, Node a, Node b) {
    if (root == null) {
      return null;
    }
//    if(root.value == a.value || root.value == b.value)
//      return root;
    Node left = findLCS(root.left, a, b);
    Node right = findLCS(root.right, a, b);

    if (left != null && right != null) {
      return root;
    }
    if (left == null && right != null) {
      if (root.value == a.value || root.value == b.value) {
        return root;
      }
      return right;
    }
    if (right == null && left != null) {
      if (root.value == a.value || root.value == b.value) {
        return root;
      }
      return left;
    }
    if (root.value == a.value
        || root.value == b.value) {
      return root;
    }
    return null;
  }
}
