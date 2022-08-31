//leetcode.com/problems/binary-tree-preorder-traversal/

//Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            Deque<TreeNode> st=new ArrayDeque<>();
            st.add(root);
            while(!st.isEmpty()){
                TreeNode temp=st.poll();
                ans.add(temp.val);
                if(temp.right!=null){
                    st.push(temp.right);
                }
                if(temp.left!=null){
                    st.push(temp.left);
                }
            }
        }
        return ans;
        
        
        
    }
}

//Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
         pre(root,ans);
        return ans;
    }
    void pre(TreeNode root,List<Integer> ans){
        if(root!=null){
            ans.add(root.val);
            pre(root.left,ans);
            pre(root.right,ans);
        }
        
    }
}

//Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            ans.add(root.val);
            ans.addAll(preorderTraversal(root.left));
            ans.addAll(preorderTraversal(root.right));
        }
        return ans;
        
    }
}
