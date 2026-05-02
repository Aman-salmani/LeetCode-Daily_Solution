/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder,Integer.MAX_VALUE);
       
}
public TreeNode buildTree(int[] preorder,int bound){
    //base case//
    if(i == preorder.length || preorder[i] > bound){
        return null;
    }
    TreeNode root = new TreeNode(preorder[i++]);
    root.left = buildTree(preorder,root.val);
    root.right = buildTree(preorder,bound);
    return root;
}
}