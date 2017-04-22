# ListOfDepths
Given a Binary Tree, create a linked list of all nodes, at each depth
---

List of Depths
Given a Binary Tree, design an algorithm which creates a linked list of all nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

#### Trivial Node model
  ```java
  public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) { this.data = data; }
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
  ```
#### All the logic
```java
import java.util.ArrayList;
import java.util.LinkedList;

class ListOfDepths {
    public ArrayList<LinkedList<Node>> getListOfDepths(Node root) {
        ArrayList<LinkedList<Node>> listOfDepths = new ArrayList<LinkedList<Node>>();
        LinkedList<Node> levelList = new LinkedList<Node>();
        if (levelList != null) {
            levelList.add(root);
        }
        while(levelList.size() > 0) {
            listOfDepths.add(levelList); // Add previous level
            LinkedList<Node> parents = levelList; // Go to next level
            levelList = new LinkedList<Node>();
            for (Node parent : parents) {
                // Visit it's children
                if (parent.left != null) {
                    levelList.add(parent.left);
                }
                if (parent.right != null) {
                    levelList.add(parent.right);
                }
            }
        }
        return listOfDepths;
    }
}
```


```java
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    // Internal Class; Node class of a Binary Tree
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        Node n2 = new Node(2, n1, n3);
        Node n8 = new Node(8, n7, n9);
        Node n5 = new Node(5, n2, n8);

        ArrayList<LinkedList<Node>> listOfDepths = new ListOfDepths().getListOfDepths(n5);
        for (LinkedList<Node> list : listOfDepths) {
            for (Node node : list) {
                System.out.print(node.data + ", ");
            }
            System.out.println();
        }
    }
}
```
#### Test
Input:


         5
       /   \
      2     8
     / \   / \
    1   3 7   9


Output:
```
5,
2, 8,
1, 3, 7, 9,
```
