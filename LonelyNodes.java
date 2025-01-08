import java.util.*;
public class LonelyNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> findLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        dfs(root, lonelyNodes);
        return lonelyNodes;
    }
    private void dfs(TreeNode root, List<Integer> lonelyNodes) {
        if(root==null) return;
        if(root.left==null && root.right!=null){
            lonelyNodes.add(root.right.val);
        }
        if(root.right == null && root.left!=null){ 
            lonelyNodes.add(root.left.val);
        }
        dfs(root.left,lonelyNodes);
        dfs(root.right,lonelyNodes); 
    }
    public static void main(String[] args) {
        LonelyNodes lonelyNodesFinder = new LonelyNodes();
        LonelyNodes.TreeNode root = lonelyNodesFinder.new TreeNode(1, 
            lonelyNodesFinder.new TreeNode(2, null, 
                lonelyNodesFinder.new TreeNode(4)), 
            lonelyNodesFinder.new TreeNode(3)
        );

        List<Integer> lonelyNodes = lonelyNodesFinder.findLonelyNodes(root);
        System.out.println("Lonely nodes: " + lonelyNodes);
    }

}