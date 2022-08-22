class Solution {
    public boolean isPowerOfFour(int n) {
        if(check(n, 1)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean check(int n, long num){
        if(num > n){
            return false;
        }
        if(num == n){
            return true;
        }
        
        return check(n, num * 4);
    }
}