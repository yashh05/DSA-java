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
    public int helper(TreeNode node,String str){
        if(node.left==null && node.right==null) return Integer.parseInt(str+node.val);
        int left=0;
        int right=0;
        if(node.left!=null) left=helper(node.left,str+node.val);
        if(node.right!=null) right=helper(node.right,str+node.val);

        return left+right;
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(root,"");
    }
}

//there is another way...
int helper(TreeNode node,int sum){
    if(node==null ) return 0;
   sum=sum*10+node.val;
   if(node.left==null && node.right==null) return sum;
   return helper(node.left,sum) + helper(node.right,sum);
}