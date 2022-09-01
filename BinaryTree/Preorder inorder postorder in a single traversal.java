//www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;
public class Solution {
    static class Pair{
       BinaryTreeNode<Integer> node;
        int num;
        Pair(BinaryTreeNode<Integer> node,int num){
            this.num=num;
            this.node=node;
        }
    }
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        if(root!=null){
            Deque<Pair> st=new ArrayDeque<>();
            st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair it=st.poll();
            if(it.num==1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.left!=null){
                    st.push(new Pair(it.node.left,1));
                }
            }
            else if(it.num==2){
                in.add(it.node.data);
                it.num++;
                st.push(it);
                if(it.node.right!=null){
                    st.push(new Pair(it.node.right,1));
                }
            }else{
                post.add(it.node.data);
            }
        } 
        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
       
    }
}
