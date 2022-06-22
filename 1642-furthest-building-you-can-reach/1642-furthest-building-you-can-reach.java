class Solution {

    public int furthestBuilding(int[] A, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int totalBricksUsed = 0;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i + 1] <= A[i]) continue;
            int d = A[i + 1] - A[i];
            if (totalBricksUsed + d <= bricks) {
                totalBricksUsed += d;
                pq.add(d);
            } else if (ladders > 0) {
                if (!pq.isEmpty() && pq.peek() > d) {
                    totalBricksUsed = totalBricksUsed - pq.peek() + d;
                    pq.poll();
                    pq.add(d);
                }
                ladders--;
            } else break;
        }
        return i;
    }
}
