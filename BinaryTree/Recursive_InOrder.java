package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Recursive_InOrder {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        
        // Initialize the tree and populate it
        Implementation tree = new Implementation();
        Implementation.Node root = tree.populate(nums);
        
        // Perform Inorder traversal
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);

       
        // Print list elements
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.println("]");
    }

    static void InOrder(Implementation.Node node,List<Integer> ls){
        if(node==null)return ;
        InOrder(node.left,ls);
        ls.add(node.value);
        InOrder(node.right,ls);
    }

    
   
}
