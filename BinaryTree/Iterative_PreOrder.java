package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_PreOrder {
    public static void main(String[] args){
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        Implementation tree = new Implementation();

        // Build a Tree -->

        Implementation.Node root = tree.populate(nums);

        // Code starts here -->

        List<Integer> list = new ArrayList<>();
        if(root==null) return;
        Stack<Implementation.Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Implementation.Node curr = st.pop();
            list.add(curr.value);
            if(curr.right!=null)st.push(curr.right);
            if(curr.left!=null)st.push(curr.left);
        }
        // Display a List as a preOrder
        System.out.print("[ ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+", ");
        }      
        System.out.print("]");  
    }
}
