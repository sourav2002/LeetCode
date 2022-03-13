class Solution {
    public List<Integer> findKDistantIndices(int[] arr, int key, int k) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        List<Integer> jl = new ArrayList<>();
        for(int x = 0; x < n; x++){
            if(arr[x] == key){
                jl.add(x);
            }
        }
        
        
        for(int i=0; i< n;i++){
            for(int j = 0; j< jl.size(); j++){
                if(Math.abs(i - jl.get(j)) <= k  && arr[(int)jl.get(j)] == key){
                    set.add(i);
                    break;
                }
            }
                
            
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }
}