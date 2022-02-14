class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n+m];
        
        mergeArrays(arr1,arr2,n,m,arr3);
        
        int l3 = arr3.length;
        
        if(l3 % 2 != 0){
            return arr3[l3/2];
        }else{
            return (arr3[l3/2] + arr3[l3/2 - 1])/2.0;
        }
    }
    static void mergeArrays(int[] a1, int[] a2, int n, int m, int[] a3){
        int i = 0, j= 0, k=0;
        while(i<n && j<m){
            if(a1[i] < a2[j]){
                a3[k++] = a1[i++];
            }else{
                a3[k++] = a2[j++];
            }
        }
        while( i< n){
            a3[k++] = a1[i++];
        }
        while(j< m){
            a3[k++] = a2[j++];
        }
    }

}