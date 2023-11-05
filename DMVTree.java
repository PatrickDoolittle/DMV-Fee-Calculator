

import java.util.*;
import java.text.*;
import java.util.Scanner;

public class DMVTree {
  

    TreeNode baseFee;
    TreeNode inState;
    TreeNode outState;
    TreeNode lateReg;
    TreeNode notLateReg;
    TreeNode lateReg1;
    TreeNode lateReg2;
    TreeNode car;
    TreeNode commercial;
    TreeNode motorcycle;
    
    public TreeNode initializeTree() {
        baseFee = new TreeNode(87, "Base Fee");
        inState = new TreeNode(10, "In State");
        outState = new TreeNode(50, "Out of State");
        lateReg = new TreeNode(50, "Late Registration");
        lateReg2 = new TreeNode(30, "> 1 month");
        lateReg1 = new TreeNode(50, "< 1 month");
        notLateReg = new TreeNode(0, "On Time Registration, No Fee");
        car = new TreeNode(30, "Car");
        commercial = new TreeNode(35, "Commercial Vehicle");
        motorcycle = new TreeNode(28, "Motorcycle");
        
        
        baseFee.addChild(inState);
        baseFee.addChild(outState);
        inState.addChild(lateReg);
        inState.addChild(notLateReg);
        outState.addChild(lateReg);
        outState.addChild(notLateReg);
        lateReg1.addChild(car);
        lateReg1.addChild(commercial);
        lateReg1.addChild(motorcycle);
        lateReg2.addChild(car);
        lateReg2.addChild(commercial);
        lateReg2.addChild(motorcycle);
        notLateReg.addChild(car);
        notLateReg.addChild(commercial);
        notLateReg.addChild(motorcycle);
        
        return baseFee;
    }
     
    public void traverse(TreeNode node, User user) {
        if (node == null) return;
        user.addFee(node);
        
        String nextStep = user.getInfo().poll();
        TreeNode nextNode = null;
        for (TreeNode child : node.getChildren()) {
            if (child.getName().equals(nextStep)) {
                nextNode = child;
                break;
            }
        }
        
        traverse(nextNode, user);
    }
    
    
}