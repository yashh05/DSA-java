// question- Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        
        while(!que.isEmpty()){
           TreeNode left= que.poll();
           TreeNode right= que.poll();

           if(left==null && right==null){
               continue;
           }
           if(left==null || right==null){
               return false;
           }
           if(left.val!=right.val){
               return false;
           }

           que.offer(left.left);
           que.offer(right.right);
           que.offer(left.right);
           que.offer(right.left);
        }
        return true;
    }
}