class Solution{
    public double findMedianSortedArrays (int[] arr1, int[] arr2) {
       //if inputl length is greater than switch them so that inputl is smaller than input2.
       if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int size1 = arr1.length;
        int size2 = arr2. length;
        int low = 0;
        int high = size1;
        while (low <= high) {
            int partition1 = (low + high)/2;
            int partition2 = (size1 + size2 + 1)/2 - partition1;
            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int minRightX = (partition1 == size1) ? Integer.MAX_VALUE : arr1[partition1];
            int maxLeftY = (partition2 == 0) ? Integer.MIN_VALUE : arr2 [partition2 - 1];
            int minRightY = (partition2 == size2) ? Integer.MAX_VALUE : arr2 [partition2];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even                    length combined array size
                // or get max of left for odd length combined array size.
                if((size1 + size2) % 2 == 0){
                     return ((double)Math.max (maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                 }else{
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
             } else if (maxLeftX > minRightY) {//we are too far on right side for partitionX. Go on left side.
                high = partition1 - 1;
             } else { //we are too far on left side for partitionX. Go on right side.
                low = partition1 + 1;
            }
        }
        return 0;
    }
}

/*
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
*/