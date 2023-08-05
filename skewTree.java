package G3B1_DSA_GradedProject2;

class TreeNode {

  int value;
  TreeNode left, right;

  public TreeNode(int value) {
    this.value = value;
    this.left = this.right = null;
  }
}

public class skewTree {

  private TreeNode headNode = null;
  private TreeNode prevNode = null;

  public void buildSkewTree(TreeNode tree) {
    if (tree == null) return;

    buildSkewTree(tree.left);

    if (headNode == null) {
      headNode = tree;
      tree.left = null;
      prevNode = tree;
    } else {
      prevNode.right = tree;
      tree.left = null;
      prevNode = tree;
    }

    buildSkewTree(tree.right);
  }

  public void printSkewTree() {
    TreeNode node = headNode;
    while (node != null) {
      System.out.print(node.value + " ");
      node = node.right;
    }
  }
}

class Main {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(50);
    tree.left = new TreeNode(30);
    tree.right = new TreeNode(60);
    tree.left.left = new TreeNode(10);
    tree.right.left = new TreeNode(55);

    skewTree skewTree = new skewTree();
    skewTree.buildSkewTree(tree);
    skewTree.printSkewTree();
  }
}
