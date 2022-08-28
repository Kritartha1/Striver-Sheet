//www.codingninjas.com/codestudio/problems/1112629?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=3
//practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
//Approach 1:
public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        // Write your code here.
        if(m>n){
            return ninjaAndLadoos(row2,row1,n,m,k);
        }
        int l=0;
        int r=Math.min(k,m);
        
        while(l<=r){
            int cut1=(l+r)/2;
            int cut2=k-cut1;
            
            if(cut2>n){
                l=cut1+1;
            }else{
             
            int l1=(cut1==0)?Integer.MIN_VALUE:row1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:row2[cut2-1];
            int r1=(cut1==m)?Integer.MAX_VALUE:row1[cut1];
            int r2=(cut2==n)?Integer.MAX_VALUE:row2[cut2];
            
            if(l1<=r2&&l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                r=cut1-1;
            }else{
                l=cut1+1;
            }
            }
            
            
        }
        return -1;
    }
}

//Appraoch 2:
class Solution {
    public long kthElement( int row1[], int row2[], int m, int n, int k) {
        if(m>n){
            return kthElement(row2,row1,n,m,k);
        }
        int l;
        int r=Math.min(k,m);
        
        //cut1
        //cut2=k-cut1
        //if(cut2>n)--> means we have to increase cut 1
        //so cut2<=n always--> k-cut1<=n==>cut1>=(n-k)
        //cut1>=(k-n)
        //i.e min value of cut1= l
        //l= Math.max(0,k-n);
        
        l= Math.max(0,k-n);
        
        while(l<=r){
            int cut1=l+(r-l)/2;
            int cut2=k-cut1;
            
            int l1=(cut1==0)?Integer.MIN_VALUE:row1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:row2[cut2-1];
            int r1=(cut1==m)?Integer.MAX_VALUE:row1[cut1];
            int r2=(cut2==n)?Integer.MAX_VALUE:row2[cut2];
            
            if(l1<=r2&&l2<=r1){
                return Math.max(l1,l2);
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
