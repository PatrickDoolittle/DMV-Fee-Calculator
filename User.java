

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class User {
        private String name;
        private Queue<String> info;
        private List<TreeNode> receipt;
        private double percentage;
        private double sum;
        private NumberFormat currency;
        
        public User(Queue<String> info, String name) {
            this.sum = 0;
            this.info = info;
            this.receipt  = new ArrayList<>();
            this.name = name;
            percentage = 0.0;
        }
        
        public void addFee(TreeNode transaction) {
            String percent1 = "< 1 month";
            String percent2 = "> 1 month";
            
            if(transaction.getName().equals(percent1) || transaction.getName().equals(percent2)){
                percentage = transaction.getValue() / 100;
            }
            else
                this.sum += transaction.getValue();
            
            receipt.add(transaction);
        }
        
        public Queue<String> getInfo(){
        return info;
        }
        
        public void displayReceipt() {
            System.out.println("Receipt for user " + name + ":");
            currency = NumberFormat.getCurrencyInstance();
            for (TreeNode f : receipt) {
                System.out.println(f.getName() + ": ");
                if(f.getName().equals("< 1 month") || f.getName().equals("> 1 month"))
                {
                    System.out.println(f.getValue() + "%");
                }
                else
                     System.out.println(currency.format(f.getValue()));
            }
            double total = sum * (1 + percentage);
            System.out.println("Total: " + currency.format(total) + "\n");
        }
    }
