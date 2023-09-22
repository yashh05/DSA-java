//inorder and preorder array are given and we can derive the tree using that. 
//2nd approach is by using hashmap

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;

        int nodeVal=preorder[0];
        TreeNode root=new TreeNode(nodeVal);
        
        int leftLength=0;

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==nodeVal) break;
            else leftLength++;
        }
        
        root.left=buildTree(Arrays.copyOfRange(preorder,1,leftLength+1),Arrays.copyOfRange(inorder,0,leftLength));
        root.right=buildTree(Arrays.copyOfRange(preorder,leftLength+1,preorder.length),Arrays.copyOfRange(inorder,leftLength+1,inorder.length));
        // int[] newLeft=new int[leftLength];
        // int[] newRight=new int[inorder.length-1-leftLength];

        // for(int i=0;i<newLeft.length;i++){
        //     newLeft[i]=
        // }
        return root;
    }
}