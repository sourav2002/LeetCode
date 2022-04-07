class Solution {

    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for( int a :stones){
            pq.add(a);
        }
        
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            
            if(a==b){
                continue;
            }else 
                pq.add(Math.abs(a-b));
            }
        if(pq.isEmpty()){
            return 0;
        }
            
        
        return pq.peek();
    }
}
