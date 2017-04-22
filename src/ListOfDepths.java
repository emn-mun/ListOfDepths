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

