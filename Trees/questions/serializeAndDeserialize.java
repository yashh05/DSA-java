/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    private void helper(TreeNode node,List<String> list){
        if(node==null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);
    }

    private TreeNode helper2(List<String>list){
      String val= list.remove(list.size()-1);  
      if(val.charAt(0)=='n') return null;
      TreeNode node= new TreeNode(Integer.parseInt(val));
      node.left= helper2(list);
      node.right= helper2(list);

      return node;            
    }

    public String serialize(TreeNode root) {
        List<String> list=new ArrayList<>();
        helper(root,list);
        return String.join(",", list );

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strSplit = data.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(strSplit));
        Collections.reverse(list);
        return helper2(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));