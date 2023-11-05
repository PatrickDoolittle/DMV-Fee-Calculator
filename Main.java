 //Authors: Enrique De la Torre, Patrick Doolittle Kavita Kem, Kevin Zhang, Eric Cheyssial
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        DMVTree tree = new DMVTree();

        TreeNode baseFees = tree.initializeTree();
         
        Queue<String> info1 = new LinkedList<>(Arrays.asList("In State", "Late Registration", "< 1 month", "Motorcycle"));
        User user1 = new User(info1,"Jack Daniels");
        tree.traverse(baseFees, user1);
        user1.displayReceipt();
        
        Queue<String> info2 = new LinkedList<>(Arrays.asList("Out of State", "On Time Registration", "Car"));
        User user2 = new User(info2,"Corey Hill");
        tree.traverse(baseFees, user2);
        user2.displayReceipt();
    }
}
