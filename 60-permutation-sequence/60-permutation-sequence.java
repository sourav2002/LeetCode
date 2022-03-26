class Solution {
    public String getPermutation(int n, int k) {
        
        int fact = 1; 
        List<Integer> num = new ArrayList();// create num
        // count initital factorial
        for(int i= 1; i< n;i++){
            fact *= i;
            num.add(i);
        }
        
        num.add(n); // complete the number bcz loop only run till less then n
        String ans = ""; // for final ans
        k = k-1; // bcz 0 indexed permutation logic
        
        while(true){            
            ans = ans + num.get( k / fact);
            num.remove(k/fact);
            
            if(num.size() == 0) break; // condition after removing k/fast from num to avoid airthmeticException
            // in fact / num.size()  bcz num.size() can be 0
            
            k = k % fact;
            fact = fact / num.size(); // size of new list (initially 3 and then 2 ...1..)
        }
        return ans;
    }
}