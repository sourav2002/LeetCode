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
