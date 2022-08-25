//www.codingninjas.com/codestudio/problems/630450?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
1.
class Solution {
    public int search(int[] arr, int key) {
        int pivot=-1;
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]>=arr[l]){
                if(key>=arr[l]&key<=arr[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
                
            }else{
                if(key>=arr[mid]&key<=arr[r]){
                   l=mid+1;
                }else{
                   r=mid-1;
                }
            }
            
        }
        
        return -1;
    }
}


2.




public class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
        int pivot=-1;
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr[mid]<arr[0]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        pivot=r;
        //System.out.println("pivot:"+pivot);
        if(key>=arr[pivot]&&key<=arr[n-1]){
            l=pivot;
            r=n-1;
        }
        else if(pivot>0&&key<=arr[pivot-1]&&key>=arr[0]){
            l=0;
            r=pivot-1;
        }else{
         
            return -1;
        }
        
        while(l<=r){
            int m=l+(r-l)/2;
            if(arr[m]==key){
                return m;
            }
            if(arr[m]>key){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return -1;
       
        
    }
}
