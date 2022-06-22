class Solution {

    public int furthestBuilding(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for(i = 0; i<A.length-1; i++){
            if(A[i+1] <= A[i]) continue;
            int d = A[i+1] - A[i];
            if(d <= bricks){
                bricks -= d;
                pq.add(d);
            }else if(ladders > 0){
                if(pq.size() > 0){
                    int x = pq.peek();
                    if(x > d){
                        pq.poll();
                        bricks += x;
                        pq.add(d);
                        bricks -= d;
                    }
                }
                ladders--;
            }
            else break;
        }
        return i;
    }
}
