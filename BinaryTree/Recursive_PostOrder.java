package BinaryTree;
import java.util.*;
public class Recursive_PostOrder {
    public static void main(String[] args){
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        Implementation tree = new Implementation();
        Implementation.Node root = tree.populate(nums);
        List<Integer> list = new ArrayList<>();
        PostOrder(root,list);

        // Display Tree in PostOrder
        System.out.print("[");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+", ");
        }
        System.out.print("]");

    }

    static void PostOrder(Implementation.Node root, List<Integer> list){
        if(root==null)return;
        PostOrder(root.left,list);
        PostOrder(root.right,list);
        list.add(root.value);
    }
}
