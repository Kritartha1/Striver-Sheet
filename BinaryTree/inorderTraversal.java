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


//Morris Traversal

// Step 1: Initialize current as root

// Step 2: While current is not NULL,

// If current does not have left child

//     a. Add current’s value

//     b. Go to the right, i.e., current = current.right

// Else

//     a. In current's left subtree, make current the right child of the rightmost node

//     b. Go to this left child, i.e., current = current.left
    
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new LinkedList<>();
        TreeNode curr=root;
        TreeNode pre;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                pre=curr.left;
                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=curr;
                TreeNode temp=curr;
                curr=curr.left;
                temp.left=null;
            }
        }
        return ans;
    }
}
