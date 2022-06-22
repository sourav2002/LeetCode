class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int bricksUsed = 0;
        int n = heights.length;
        int i = 0;
        for (; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            // If current height is higher, we don't have to use
            // bricks or ladder.
            if (diff <= 0) {
                continue;
            }

            // We have to use either brick or ladder.
            if (diff + bricksUsed <= bricks) {
                // Prefer bricks because we can later change from
                // bricks to ladder as we will see below.
                bricksUsed += diff;
                pq.add(diff);
            } else if (ladders > 0) {
                // If even bricks are insufficient, check ladders.
                if (!pq.isEmpty() && pq.peek() > diff) {
                    bricksUsed += diff - pq.peek();
                    pq.poll();
                    pq.add(diff);
                }
                ladders--;
            }
            // Unfortunately, it's not possible to go ahead any further.
            else break;
        }
        // This is the max we can go ahead.
        return i;
    }
}
