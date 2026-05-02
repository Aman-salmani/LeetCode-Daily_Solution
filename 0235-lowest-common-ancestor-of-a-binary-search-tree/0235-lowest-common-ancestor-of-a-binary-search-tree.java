/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val){
             //if root is null or equl to target return root//
            return root;  
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q); 
        //search leftSubtree for targer//
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //Search rightSubtree for Target//
        if(left == null){
            return right;
            //if left null i.e.traget must be in right//
        }
        if(right == null){
            return left;
            //if right null target must be in left//
        }
        return root; //it mean target in both left and right subtree//
    }
}