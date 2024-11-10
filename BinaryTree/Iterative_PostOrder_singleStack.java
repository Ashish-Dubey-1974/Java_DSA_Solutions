package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Iterative_PostOrder_singleStack {
    public static void main(String[] args){
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        Implementation tree = new Implementation();

        // build a tree --->
        Implementation.Node root = tree.populate(nums);

        // Code  --->
        List<Integer> list = new ArrayList<>();
        Stack<Implementation.Node> st = new Stack<>();
        Implementation.Node curr = root;
        Implementation.Node visitedNode = null;
        while(curr!=null||!st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.peek();
            if(curr.right==null||curr.right==visitedNode){
                list.add(curr.value);
                st.pop();
                visitedNode=curr;
                curr=null;
            }else{
                curr = curr.right;
            }
        }

        //Display Tree in PostOrder

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.print("]");

    }
}
