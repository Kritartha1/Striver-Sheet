//https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class Solution {
    static double mod=1e9+1;
    static double pow(double a,int n){
        double ans=1;
        while(n>0){
            if((n&1)!=0){
                ans=(ans*a)%mod;
            }
            a=(a*a)%mod;
            n/=2;
        }
        return ans;
    }
	public static double findNthRootOfM(int n, int m) {
		// Write your code here.
        double l=1;
        double r=m;
        
        double e=1e-9;
        while((r-l)>e){
            double mid=l+(r-l)/2;
            double x=pow(mid,(int)n);
            if(x>m){
                r=mid;
            }else{
                l=mid;
            }
        }
        return l;
        
        
	}
}
