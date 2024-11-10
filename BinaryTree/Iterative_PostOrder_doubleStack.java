package BinaryTree;

import java.util.Stack;

public class Iterative_PostOrder_doubleStack {
    public static void main(String[] args){
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        Implementation tree = new Implementation();
        Implementation.Node root = tree.populate(nums);

        // code -->
        Stack<Implementation.Node> st1 = new Stack<>();
        Stack<Implementation.Node> st2 = new Stack<>();

        st1.push(root);
        while (!st1.isEmpty()) {
            Implementation.Node curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null)st1.push(curr.left);
            if(curr.right!=null)st1.push(curr.right);
        }

        System.out.print("[");
        while(!st2.isEmpty()){
            System.out.print(st2.pop().value+", ");
        }
        System.out.print("]");
    }
}
