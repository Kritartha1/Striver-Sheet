//leetcode.com/problems/binary-tree-inorder-traversal/

//Stack approach:

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Deque<TreeNode> st=new ArrayDeque<>();
        
        while(root!=null||!st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
                
            }
            root=st.poll();
            ans.add(root.val);
            root=root.right;
        }
        return ans;
    }
    
    
}

//Recursion approach:

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        solve(root,ans);
        return ans;
    }
    
    void solve(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        solve(root.left,ans);
        ans.add(root.val);
        solve(root.right,ans);
    }
}

