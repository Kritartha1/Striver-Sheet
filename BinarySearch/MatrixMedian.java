import java.util.ArrayList;


//www.codingninjas.com/codestudio/problems/873378?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class Solution
{
    static int bs(ArrayList<Integer> row,int val){
        int l=0;
        int r=row.size();
        while(l<r){
            int m=l+(r-l)/2;
            if(row.get(m)>val){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		// Write your code here.
        int l=1;
        int r=100000;
        
        int m=matrix.size();
        int n=matrix.get(0).size();
        while(l<r){
            int mid=l+(r-l)/2;
            int count=0;
            for(int i=0;i<m;i++){
                count+=bs(matrix.get(i),mid);
            }
            if(count>=((m*n+1)/2)){
                r=mid;
            }else{
                l=mid+1;
            }
            
        }
        return l;
	}
}
