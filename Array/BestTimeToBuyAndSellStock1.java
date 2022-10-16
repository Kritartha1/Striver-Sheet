class Solution {
    public int maxProfit(int[] prices) {
        int min=(int)(1e4+1);
        int ans=-1;
        for(int i=0;i<prices.length;i++){
            min=Math.min(prices[i],min);
            ans=Math.max(prices[i]-min,ans);
        }
        return ans;
        
    }
}
