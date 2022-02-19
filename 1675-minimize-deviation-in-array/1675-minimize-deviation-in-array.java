class Solution {
    public int minimumDeviation(int[] arr) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i : arr){
            if(i %2 != 0) i *= 2;
            ts.add(i);
        }
        
        int diff = Integer.MAX_VALUE;
        while(true){
            int max = ts.last();
            diff = Math.min(diff, ts.last() - ts.first());
            
            if(max %2 != 0){
                break;
            }else{
                ts.remove(max);
                ts.add(max/2);
            }
            
        }
        
        return diff;
    }
}
/*
If the element is odd, multiply it by 2 so when we multiply an odd number with 2, it becomes even 
so it is clear that we can multiply a odd number only once

Use treeset because it return any element with time O(1) we need to find 1st and last element multiple times
add arr in treeset and if any number is odd then num*2 and add in set

now we can reduce diff by dividing max even number 
run while loop ..until max element is even 
store the diff of max - min

and everytime remove the current max element from treeset and add half of current max value in treeset


*/