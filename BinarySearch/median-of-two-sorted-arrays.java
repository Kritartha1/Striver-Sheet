//leetcode.com/problems/median-of-two-sorted-arrays/
//www.youtube.com/watch?v=NTop3VTjmxk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=66
public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
       int m=a.length;
        int n=b.length;
        
        if(m>n){
            return median(b,a);
        }
        
        int l=0;
        int r=m;
        int k=(n+m+1)/2;
        int l1,l2,r1,r2;
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        while(l<=r){
            int cut1=l+(r-l)/2;
            l1=(cut1==0)?min:a[cut1-1];
            l2=(k-cut1)==0?min:b[k-cut1-1];
            r1=(cut1==m)?max:a[cut1];
            r2=(k-cut1)==n?max:b[k-cut1];
            
            if((l1<=r2)&&(l2<=r1)){
                if((n+m)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))*1.0/2;
                }else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                r=cut1-1;
            }else{
                l=cut1+1;
            }
        }
        return -1;
    }
}
