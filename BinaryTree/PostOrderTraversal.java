//leetcode.com/problems/binary-tree-postorder-traversal/

//Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            ans.addAll(postorderTraversal(root.left));
            ans.addAll(postorderTraversal(root.right));
            ans.add(root.val);
            
        }
        return ans;
    }
}


//Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        
        if(root!=null){
            Deque<TreeNode> st=new ArrayDeque<>();
            st.push(root);
            while(!st.isEmpty()){
                root=st.poll();
                ans.add(0,root.val);
                if(root.left!=null){
                    st.push(root.left);
                }
                if(root.right!=null){
                    st.push(root.right);
                }

            }
        }
        
        return ans;
    }
}



//Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        
        if(root!=null){
            Deque<TreeNode> st=new ArrayDeque<>();
            
            TreeNode curr=root;
            TreeNode temp;
            while(curr!=null||!st.isEmpty()){
                if(curr!=null){
                    st.push(curr);
                    curr=curr.left;
                }else{
                    temp=st.peek().right;
                    if(temp==null){
                        temp=st.poll();
                        ans.add(temp.val);  
                        while(!st.isEmpty()&&temp==st.peek().right)                         {
                            temp=st.poll();
                            ans.add(temp.val);
                        }
                    }
                    else{
                        curr=temp;
                    }
                    
                }
            }
        }
        
        return ans;
    }
}
