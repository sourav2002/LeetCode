class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while( l < r){
            int lheight = height[l];
            int rheight = height[r];
            
            int dist = r-l;
            
            int prod= dist * Math.min(lheight, rheight);
            
            max = Math.max(max, prod);
            
            if(lheight < rheight){
                l++;
            }else{
                r--;
            }   
        }
        
        return max;
    }
}