package algorithmes;

public class TreeNode {
    TreeNode left,right;
    String value;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        treeNode.left = nodeB;
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");;
        TreeNode nodeG = new TreeNode("G");;
        TreeNode nodeH = new TreeNode("H");;
        treeNode.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeC.left = nodeF;
        nodeC.right = nodeG;

        nodeE.right = nodeH;
        treeNode.print();


    }

    public String toString() {
        return value;
    }

    TreeNode(String value) {
      this.value = value;
    }

    private void printSelfAndChieldren() {
        if(this.left != null)
            System.out.print(this.left + " -> ");
        if(this.right != null)
            System.out.print(this.right + " -> ");
    }

    private void drill() {

        this.left.printSelfAndChieldren();
        this.right.printSelfAndChieldren();
    }

    public void print() {

        System.out.print(this.value + " -> ");
        printSelfAndChieldren();
        this.drill();
        this.left.drill();
        this.right.drill();
    }
}
