class Solution {
    public long waysToBuyPensPencils(int t, int c1, int c2) {
        long c = 0;
        long current = 0;
        
        while(current <= t){
            c += (t - current)/c2 +1;
            current += c1;
        }
        return c;
    }
}