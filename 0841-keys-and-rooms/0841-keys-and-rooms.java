class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet();
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<rooms.get(0).size(); i++){
            int key = rooms.get(0).get(i);
            set.add(key);
            if(key != 0) q.add(key);
        }
        set.add(0);
        while(!q.isEmpty()){
            int i = q.remove();
            for(int j = 0; j <rooms.get(i).size(); j++){
                int key = rooms.get(i).get(j);
                if(!set.contains(key)) q.add(key);
                set.add(key);
            }
        }
        for(int i=0; i<rooms.size(); i++){
            if(!set.contains(i)) return false;
        }
        return true;
    }
}