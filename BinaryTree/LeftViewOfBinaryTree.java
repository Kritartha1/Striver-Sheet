//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

//Appraoch 1: null node

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root!=null){
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            
            //null node is to seperate each level ..
            //when null node is seen, means the next node is the starting of a new level..
            //or it is the end of tree traversal.
            //if starting of new level..->make isFirst=true ans remove null ..and add it to position next to last node of next level
            
            //if null is the only node left--> means end of level ..
            //so break the loop...which is facilitiated by q.size()>1
            boolean isFirst=true;
            while(q.size()>1){
                Node temp=q.poll();
                if(temp==null){
                    q.add(temp);
                    isFirst=true;
                }else{
                    if(isFirst){
                        ans.add(temp.data);
                        isFirst=false;
                    }
                    
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
            }
        }
       
        return ans;
        
    }
}

//Approach 2: Two queues.
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root!=null){
            Queue<Node> q=new LinkedList<>();
            Queue<Node> q2=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int t=q.size();
                int n=t;
                while(t>0){
                    Node curr=q.poll();
                    if(t==n){
                        ans.add(curr.data);
                    }
                    if(curr.left!=null){
                        q2.add(curr.left);
                    }
                    if(curr.right!=null){
                        q2.add(curr.right);
                    }
                        
                    --t;
                        
                }
                q=q2;
            }
        }
       
        return ans;
        
    }
}
