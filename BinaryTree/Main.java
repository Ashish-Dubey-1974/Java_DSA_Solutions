package BinaryTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Implementation tree = new Implementation();
        tree.populate(scanner);
        tree.display();
    }
}
