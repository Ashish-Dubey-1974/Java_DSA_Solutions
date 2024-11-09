package BinaryTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Implementation of BinaryTree
        Implementation tree = new Implementation();
        tree.populate(scanner);
        tree.display();//Fucntion to display a tree
        tree.prettyDisplay();// function to display a tree inn Style (' ^ ')

//---------------------------------------------------------------------------------------------------------------------------\\

        //Implamentation of Binary Search Tree
        BST BinaryTree = new BST();
        int[] nums = {6,5,1,8,3,5,4,7};
		BinaryTree.populate(nums);
		BinaryTree.display();

=======
        tree.prettyDisplay();// function to display a tree with Styling (' ^ ')
>>>>>>> 900a4f1ddc5315811bdcd25ac05ddc2ef1a9fbf4
    }
}
