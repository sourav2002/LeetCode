class Solution {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n + 1], mod = (long) 1e9 + 7, share = 0, res = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i){
            dp[i] = share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + mod) % mod;
        }
        
        for (int i = n - forget + 1; i <= n; ++i){
            res = (res + dp[i]) % mod;
        }
        return (int) res;
    }
}
/*
class Solution {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000000 + 7;
        List<pair> list = new ArrayList();
        list.add(new pair(1 + delay, 1 + forget, 1));
        for (int i = 2; i <= n; i++) {
            // remove all expired date.
            while (!list.isEmpty() && list.get(0).e == i) {
                list.remove(0);
            }
            long cnt = 0;

            for (pair p : list) {
                if (p.s <= i) {
                    cnt += p.c;
                }
                cnt %= mod;
            }
            list.add(new pair(i + delay, i + forget, (int)cnt));
        }

        long ans = 0;
        for(pair p : list){
            ans += p.c;
            ans %= mod;
        }
        return (int)ans;
    }

    public static class pair {
        int s;
        int e;
        int c;

        public pair(int st, int end, int count) {
            s = st;
            e = end;
            c = count;
        }
    }
}
*/
