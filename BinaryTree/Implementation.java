package BinaryTree;
import java.util.Scanner;
class Implementation{
    public Implementation(){
        
    }
    private class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value = value;
        }
    }
        private Node root;

        public void populate(Scanner scanner){
            System.out.println(" Enter the Root Nodes");
            int value = scanner.nextInt();
            root = new Node(value);
            populate(scanner,root);
        }
        private void populate(Scanner scanner, Node node){
            System.out.println("Do you want to enter left of "+node.value);
            boolean left = scanner.nextBoolean();
            if(left){
                System.out.println("Enter the value of the left of "+node.value);
                int value = scanner.nextInt();
                node.left = new Node(value);
                populate(scanner, node.left);
            }

            System.out.println("Do you want to enter right of "+node.value);
            boolean right = scanner.nextBoolean();
            if(right){
                System.out.println("Enter the value of the left of "+node.value);
                int value = scanner.nextInt();
                node.left = new Node(value);
                populate(scanner, node.left);
            }
        }
        public void display(){
            display(this.root,"");
        }
        private void display(Node node , String indent){
            if(node==null){
                return;
            }
            System.out.println(indent+node.value);
            display(node.left, indent+"\t");
            display(node.right, indent+"\t");
        }

}