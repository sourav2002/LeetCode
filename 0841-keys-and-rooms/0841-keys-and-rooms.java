class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet();
        Queue<Integer> q = new LinkedList();
        q.add(0);
        set.add(0);
        while (!q.isEmpty()) {
            int i = q.remove();
            for (int key : rooms.get(i)) {
                if (!set.contains(key)) {
                    q.add(key);
                    set.add(key);
                    if (set.size() == rooms.size()) return true;
                }
            }
        }

        return set.size() == rooms.size();
    }
}
