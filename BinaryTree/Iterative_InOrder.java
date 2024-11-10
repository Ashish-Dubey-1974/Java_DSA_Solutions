package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Iterative_InOrder {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        
        // Initialize the tree and populate it
        Implementation tree = new Implementation();
        Implementation.Node root = tree.populate(nums);
        
        // Perform Inorder traversal
        List<Integer> list = new ArrayList<>();
        Stack<Implementation.Node> st = new Stack<>();
        Implementation.Node curr = root;
        while(curr!=null||!st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.value);
            curr = curr.right;
        }

         // Print list elements
         System.out.print("[");
         for (int i = 0; i < list.size(); i++) {
             System.out.print(list.get(i)+", ");
         }
         System.out.println("]");
    }
}
