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
        Integer[] arrayNumbers = set.toArray(new Integer[set.size()]);
        int num = rndm.nextInt(set.size());
        return arrayNumbers[num];
    }
}
