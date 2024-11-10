package BinaryTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Implementation{

    static class Node{
        int value;
        Node right;
        Node left;
        public Node(int value){
            this.value = value;
        }
    }
    public Implementation(){
        
    }
    
        private Node root;

        static int idx=-1;
        public Node populate(int[] nums) {
            idx++;
            if(nums[idx]==-1)return null;
            Node newNode = new Node(nums[idx]);
            newNode.left = populate(nums);
            newNode.right = populate(nums);
            return newNode;
        }
        

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
                System.out.println("Enter the value of the right of "+node.value);
                int value = scanner.nextInt();
                node.right = new Node(value);
                populate(scanner, node.right);
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
        public void prettyDisplay(){
            prettyDisplay(root,0);
        }
        private void prettyDisplay(Node node,int level){
            if(node==null){
                return;
            }
            prettyDisplay(node.right, level+1);
            if(level!=0){
                for(int i=0;i<level-1;i++){
                    System.out.print("|/t/t");
                }
                System.out.println("|----->"+node.value);
            }else{
                System.out.println(node.value);
            }
        }



        // print Tree in A professional Style

        public static void printTreeWithSlashes(Implementation.Node root) {
            List<StringBuilder> lines = new ArrayList<>();
            buildTreeLines(root, 0, 0, lines);
    
            for (StringBuilder line : lines) {
                System.out.println(line.toString());
            }
        }
    
        private static void buildTreeLines(Implementation.Node node, int level, int pos, List<StringBuilder> lines) {
            if (node == null) return;
    
            if (lines.size() <= level) {
                lines.add(new StringBuilder());
            }
    
            StringBuilder line = lines.get(level);
            while (line.length() < pos) {
                line.append(" ");
            }
    
            line.append(node.value);
    
            int offset = 6;
    
            if (node.left != null) {
                buildTreeLines(node.left, level + 1, pos - offset, lines);
                StringBuilder slashLine = ensureLine(lines, level + 1);
                while (slashLine.length() < pos - 3) { 
                    slashLine.append(" ");
                }
                slashLine.append("/");
            }
    
            if (node.right != null) {
                buildTreeLines(node.right, level + 1, pos + offset, lines);
                StringBuilder slashLine = ensureLine(lines, level + 1);
                while (slashLine.length() < pos + 3) { 
                    slashLine.append(" ");
                }
                slashLine.append("\\");
            }
        }
    
        private static StringBuilder ensureLine(List<StringBuilder> lines, int level) {
            if (lines.size() <= level) {
                lines.add(new StringBuilder());
            }
            return lines.get(level);
        }
}
    
