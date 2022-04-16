class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long c = 0;
        long current = 0;
        
        while(current <= total){
            c += (total - current)/cost2 +1;
            current += cost1;
        }
        return c;
    }
}
/*
Dry run - 
total = 20
cost1 = 10, cost2 = 5

when we don't select 1st one then remaning money will be 20 - 0 = 20
and from 20 we can buy 4 pencil of cost 5,  5+5+5+5 = 4 or we can say (money / cost2)
and one case if we don't select 2nd pen/pencil too

now if we select 1 pen, remaning cost is 20 - 10 = 10
from 10 we can buy -> (10 / cost2) = 2 + 1 for buy 0

now if we select 2 pens, remaning cost is 0
from 0 we can't buy 2nd pen so only case is to buy 0 pen from 2nd

current = 0
c = c + (totalMoney - currentMoney)/cost2 + 1
current += cost1;

current = 10
c = c + (totalMoney - current)/cost2 + 1
current += cost1

current = 20
c = c + (20 - 20)/cost2 + 1


*/