class RandomizedSet {

    Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rndm = new Random();
        Object[] arr = set.toArray();
        int num = rndm.nextInt(set.size());
        return (int) arr[num];
    }
}
