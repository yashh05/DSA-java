//find the kth smallest elemnt in BST---> use inorder traversal so that you get the sorted elements.


class Solution {
    int count=0;
    public TreeNode smallest(TreeNode node,int k){
      if(node==null) return null;
      TreeNode left=smallest(node.left,k);
      
      count[0]++;
      if(k==count[0]) return node;
      TreeNode right=smallest(node.right,k);
      return left==null? right:left;
    }
    public int kthSmallest(TreeNode root, int k) {
       return smallest(root,k).val;
    }
}