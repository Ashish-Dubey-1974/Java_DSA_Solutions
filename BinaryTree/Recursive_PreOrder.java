package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class Recursive_PreOrder {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, -1, -1, 5, 6, -1, -1, 7, -1, -1, 3, -1, 8, 9, -1, -1, -1};
        
        // Initialize the tree and populate it
        Implementation tree = new Implementation();
        Implementation.Node root = tree.populate(nums);
        
        // Perform preorder traversal
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);

        // Print the tree with slashes
        printTreeWithSlashes(root);

        // Print list elements
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+", ");
        }
        System.out.println("]");
    }

    // Preorder traversal function
    public static List<Integer> preOrder(Implementation.Node node, List<Integer> list) {
        if (node == null) return list;
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
        return list;
    }

    // Function to print the tree with slashes indicating child-parent relationships
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

        // Handle right child
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
