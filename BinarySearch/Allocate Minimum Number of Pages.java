
//www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        
        long r=0;
        long l=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            l=Math.min(l,time[i]);
            r+=time[i];
        }
        long ans=-1;
        while(l<=r){
            long mid=l+(r-l)/2;
            boolean count=solve(n,m,time,mid);
            if(count){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean solve(int n,int m,int[] time,long mid){
        long curr=0;
        for(int i=0;i<m;i++){
            if((curr+time[i])>mid){
                --n;
                curr=0;  
            }
            curr+=time[i];
            if(curr>mid){//i.e curr=time[i]...if time[i]>mid,, then we have to return false;
                return false;
            }
        }
        n--;
        return n>=0;
    }

}
