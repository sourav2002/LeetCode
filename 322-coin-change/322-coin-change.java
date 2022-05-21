// we can't go greedy if we want minimum no. of coins.
/*
class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
*/

// bfs solution
class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(amount);
        visited[amount] = true;
        int currLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(queue);
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int coin : coins) {
                    int child = curr - coin;
                    if (child == 0) {
                        return currLevel;
                    } else if (child > 0 && !visited[child]) {
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
            currLevel++;
        }

        return -1;
    }
}
