
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dmvtree.DMVTree;
import dmvtree.User;

public class Main {
    public static void main(String[] args) {
        DMVTree tree = new DMVTree();

        TreeNode baseFees = tree.initializeTree();
         
        Queue<String> info1 = new LinkedList<>(Arrays.asList("inState", "LateReg", "< 1 month", "motorcycle"));
        User user1 = new User(info1);
        tree.traverse(baseFees, user1);
        user1.displayReceipt();
        
        Queue<String> info2 = new LinkedList<>(Arrays.asList("outState", "notLateReg", "car"));
        User user2 = new User(info2);
        tree.traverse(baseFees, user2);
        user2.displayReceipt();
    }
}
