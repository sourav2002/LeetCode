class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        List<String> list = new ArrayList();
        backtrack(0, ans, list, s);
        return ans;
    }
    
    public void backtrack(int ind, List<List<String>> ans, List<String> list, String s){
        
        if(ind == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i= ind; i< s.length(); ++i){
            String sub = s.substring(ind,i+1);
            // System.out.println("substring is = "+ sub);
            if(isPalendrome(sub)){
                list.add(sub);
                backtrack(i+1, ans,list, s);
                list.remove(list.size()-1);
            }   
        }      
    }
    
    public boolean isPalendrome(String s){
        
        int l=0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}