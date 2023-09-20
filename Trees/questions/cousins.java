// question-Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//  Two nodes of a binary tree are cousins if they have the same depth with different parents.
// Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        return Depth(root,x)==Depth(root,y) && !CheckParents(root,x,y);
    }
        public int Depth(TreeNode node,int x){
      int level=0;
      Queue<TreeNode> que=new LinkedList<>();
      que.offer(node);
      while(!que.isEmpty()){
          int size=que.size();
          for(int i=0;i<size;i++){
              TreeNode temp=que.poll();
              if(temp.val==x) return level;
              if(temp.left!=null)que.offer(temp.left);
              if(temp.right!=null)que.offer(temp.right);
          }
          level++;
      }
      return -1;
    }

    public boolean CheckParents(TreeNode node,int x,int y){
       if(node.left==null && node.right==null) return false;
       if(node.left==null && node.right!=null) return CheckParents(node.right,x,y);
       if(node.right==null && node.left!=null) return CheckParents(node.left,x,y);
       if((node.left.val==x && node.right.val==y)||(node.left.val==y && node.right.val==x)) return true;

       return CheckParents(node.left,x,y) || CheckParents(node.right,x,y);
    }
}