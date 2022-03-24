class Solution {
    public int numRescueBoats(int[] p, int limit) {
        
        int c = 0;
        Arrays.sort(p);
        int left = 0;
        int right = p.length-1;
        
        while(left <= right){
            int sum = p[left] + p[right];
            if(sum > limit){
                right--;
                c++;
            }else{
                left++;
                c++;
                right--;
            }
        }
        return c;
    }
}

/*
    let suppose arr = [1,2,6,7,8,9]; (sorted)
    left index =0, right index = arr.length-1
    while(left <= right)
    left -> 1, right -> 9
    sum = 10 , limit=9 so countBoat++, and leave the greater element(right) , right--;
    
    left->1, right -> 8
    sum = 9, limit = 9,  got a perfect pair, now leave both the elements , left++, right-- and countBoat++;
    
    left ->2 , right -> 7
    sum = 9, limit = 9, leave both , left++ , right--, countBoat++;
    
    left ->6 , right -> 6
    sum = 12, limit = 9,  countBoat++, and leave right index (but now while condition gets false for left <= right)
*/