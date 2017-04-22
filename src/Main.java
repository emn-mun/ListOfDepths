/*
  List of Depths
  Given a Binary Tree, design an algorithm which creates a linked list of all nodes
  at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/

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
