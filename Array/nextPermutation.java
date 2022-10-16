//Approach 1: O(n^2)
class Solution {
    public void nextPermutation(int[] nums) {
        
        
        //Logic: find the nearest pair number from right which have nums[j]>nums[i]
        //and j<i and we need j to be as far from left as possible to get the required permutation.
        
        //This solution does exactly the same ..but with a more time complexity..O(n^2). But logic wise it is same as the optimized approach
        int idx=-1;
        int idxi=-1;
        for(int i=nums.length-1;i>0;--i){
            for(int j=i-1;j>=0;--j){
                if(nums[i]>nums[j]){ 
                    if(j+1>idx){
                        idx=j+1;
                        idxi=i;
                    }
                   
                }
                
            }
        }
        if(idx!=-1){
            nums[idxi]=nums[idxi]^nums[idx-1];
            nums[idx-1]=nums[idx-1]^nums[idxi];
            nums[idxi]=nums[idxi]^nums[idx-1]; 
        }
        
        
        int l=(idx==-1)?0:idx;
        int r=nums.length-1;
        mergeSort(l,r,nums);
    }
    
    void mergeSort(int l,int r,int[] nums){
        if(l<r){
            int mid=(l+r)>>1;
            mergeSort(l,mid,nums);
            mergeSort(mid+1,r,nums);
            merge(l,r,nums);
        }
    }
    void merge(int l,int r,int[] nums){
        int[] ans=new int[r-l+1];
        int i=l;
        int m=l+(r-l)/2;
        int j=m+1;
        int k=0;
        
        while(i<nums.length&&j<nums.length&&i<=m&&j<=r){
            if(nums[i]>nums[j]){
                ans[k++]=nums[j++];
            }else{
                ans[k++]=nums[i++];
            }
        }
        while(i<nums.length&&i<=m){
            ans[k++]=nums[i++];
        }
        while(j<nums.length&&j<=r){
            ans[k++]=nums[j++];
        }
        for(int t=l;t<=r;t++){
            nums[t]=ans[t-l];
        }
    }
}


//Approach 2:
class Solution {
    public void nextPermutation(int[] nums) {
        
        
        //This solution does exactly the same ..but with a less time complexity..O(n). But logic wise it is same as the merge sort
        //https://leetcode.com/media/original_images/31_nums_graph.png
        
        int idx=-1;
        
        for(int i=nums.length-1;i>0;--i){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }
        int i=nums.length-1;
        
        if(idx>=0){
            while(i>=0&&nums[i]<=nums[idx]){
                --i;
            }
            swap(i,idx,nums);
        }
        
        
        reverse(idx+1,nums);
    }
    void swap(int i,int j,int[] nums){
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }
    
    void reverse(int i,int[] nums){
        int j=nums.length-1;
        while(i<j){
            swap(j--,i++,nums);
            
        }
    }
   
}
