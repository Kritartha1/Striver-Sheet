//Approach 1: 2 pass solution

   public void sortColors(int[] nums) {
        int[] cnt=new int[3];
        for(int i=0;i<nums.length;i++){
            cnt[nums[i]]++;
        }
        int j=0;
        for(int i=0;i<nums.length;){
            while(cnt[j]==0){
                ++j;
            }
            nums[i++]=j;
            cnt[j]--;
        }
   }
   
//Approach 2: 1 pass solution
   
    public void sortColors(int[] nums) {
        
        int i=0;
        int j=nums.length-1;
        int k=0;
        for(;k<nums.length;){
            if(nums[k]==0&&i<nums.length&&i<k){
                
                nums[k]=nums[k]^nums[i];
                nums[i]=nums[k]^nums[i];
                nums[k]=nums[k]^nums[i++];
            }
            else if(nums[k]==2&&j>=0&&j>k){
                nums[k]=nums[k]^nums[j];
                nums[j]=nums[k]^nums[j];
                nums[k]=nums[k]^nums[j--];
            }else{
                k++;
            }
        }
        
    }
