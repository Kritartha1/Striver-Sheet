class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(currSum+nums[i]<nums[i]){
                currSum=nums[i];
            }else{
                currSum+=nums[i];
            }
            max=Math.max(currSum,max);
        }
        return max;
    }
}
