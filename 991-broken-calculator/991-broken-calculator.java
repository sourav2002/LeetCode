class Solution {
    public int brokenCalc(int startValue, int target) {
        int c =0;
        while(target != startValue){
            if(target <startValue) {
                target++;                    
                c++;
            }
            else {
                
                if(target %2 == 1) {
                    c++;
                    target++;
                }else{
                    target /=2;
                    c++;
                }
            }
        }
        return c;
    }
}