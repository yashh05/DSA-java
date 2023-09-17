public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root;

    public SegmentTree(int arr[]){
        this.root=constructTree(arr,0,arr.length-1);
    }

    private Node constructTree(int[] arr,int start,int end){
        //base condition
      if(start==end){
          Node leafNode=new Node(start,end);
          leafNode.data= arr[start];
          return leafNode;
      }

      Node node= new Node(start,end);
      int mid=(start+end)/2;
      node.left=this.constructTree(arr,start,mid);
      node.right=this.constructTree(arr,mid+1,end);

      node.data=node.left.data + node. right.data;
      return node;
    }

    public void display(){
        display(this.root);
    }
     private void display(Node node){
        String str="";

        if(node.left !=null){
            str=str+ "interval=["+node.left.startInterval+"-"+node.left.endInterval+"] and data :"+node.left.data+"=>";
        }else{
            str= str+"No left Child";
        }

        //for current node
         str=str+ "interval=["+node.startInterval+"-"+node.endInterval+"] and data :"+node.data+" <= ";

         if(node.right !=null){
             str=str+ "interval=["+node.right.startInterval+"-"+node.right.endInterval+"] and data :"+node.right.data;
         }else{
             str= str+"No right Child";
         }

         System.out.println(str+"\n");
         //call recursion
         if(node.left !=null){
             display(node.left);
         }
         if(node.right !=null){
             display(node.right);
         }

     }

     //query
    public int query(int qsi,int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startInterval>=qsi &&  node.endInterval <=qei){
            return node.data;
        }
        else if(node.startInterval >  qei || node.endInterval<qsi){
            return 0;
        }else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi,qei);
        }
    }

    //update
    public void update(int index,int value){
        this.root.data=update(this.root, index,value);
    }
    private int update(Node node,int index,int value){
        if(index>=node.startInterval && index<=node.endInterval){
          if(index==node.startInterval && index== node.endInterval){
              node.data=value;
              return node.data;
          }
          else{
              node.data = update(node.left,index,value) + update(node.right,index,value);
          }
        }
        return node.data;
    }

}
