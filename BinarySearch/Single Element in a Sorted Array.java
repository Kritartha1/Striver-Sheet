//https://www.codingninjas.com/codestudio/problems/1112654?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
//https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/627921/Java-or-C%2B%2B-or-Python3-or-Easy-explanation-or-O(logn)-or-O(1)
1.
import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
         int low = 0 , high = arr.size()-1;
        
        while(low < high){
            int mid = (high+low)/2;
            if(arr.get(mid).equals(arr.get(mid^1)))
            {
                low = mid+1;
                 
            }   
            
            else{
                high = mid;
            }
                
        }
        return arr.get(low);
    }
}





2.
import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        //    Write your code here.
        int l=0;
        int r=arr.size()-1;
        int n=arr.size();
        while(l<r){
            int mid=l+(r-l)/2;

            if(mid%2==0){
                if((mid<(n-1))&&!arr.get(mid+1).equals(arr.get(mid))){
                    r=mid;
                }else{
                    l=mid+2;
                }
            }else{
                if((mid>0)&&arr.get(mid-1).equals(arr.get(mid))){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
                
            }
        }
        return arr.get(r);
        
        
    }
}
