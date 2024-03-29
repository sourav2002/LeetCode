/*
class Solution {
    public int trap(int[] height) {
        Stack<Integer> x= new Stack<>();
        int distance,top,b_height,ans=0;
        
        for(int i=0;i<height.length;i++){
            while(!x.empty() && height[i]>height[x.peek()]){
                top=x.pop();
                if(x.empty()){
                    //distance=0;
                    break;
                }
                distance=i-x.peek()-1;
                b_height=Math.min(height[i],height[x.peek()]) - height[top];
                ans=ans+(distance*b_height);
              
            }
            x.push(i);
        }
        return ans;
    }
}
*/
class Solution {
    public int trap(int[] height) {
        // time : O(n)
        // space : O(1)
        if (height.length==0) return 0; 
        int left = 0, right = height.length-1; 
        int leftMax=0, rightMax=0; 
        int ans = 0; 
        while (left < right) {
            if (height[left] > leftMax) leftMax = height[left]; 
            if (height[right] > rightMax) rightMax = height[right];
            if (leftMax < rightMax) {
                ans += Math.max(0, leftMax-height[left]); 
                left++; 
            } else {
                ans += Math.max(0, rightMax-height[right]); 
                right--; 
            }
        }
        return ans; 
    }
}

/*
class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int maxht = 0,index=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>maxht){
                maxht=height[i];
                index=i;
            }
        }
        int localmax=height[0];
        int water=0;
        for(int i=1;i<index;i++){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
        localmax=height[height.length-1];
        for(int i=height.length-2;i>index;i--){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
        return water;
    }
}
*/

/*
class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int maxht = 0,index=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>maxht){
                maxht=height[i];
                index=i;
            }
        }
        int localmax=height[0];
        int globalmax=height[index];
        int water=0;
        for(int i=1;i<index;i++){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
        localmax=height[height.length-1];
        for(int i=height.length-2;i>index;i--){
            if(height[i]<localmax){
                water+=localmax-height[i];
            }
            localmax=Math.max(localmax,height[i]);
        }
        return water;
    }
}
*/