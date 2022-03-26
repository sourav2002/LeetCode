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
/*
say n = 4, you have {1, 2, 3, 4} , k = 17th

If you were to list out all the permutations you have

1 + (permutations of 2, 3, 4)

2 + (permutations of 1, 3, 4)

3 + (permutations of 1, 2, 4)

4 + (permutations of 1, 2, 3)

here fact = n-1! = 3! = 6
k = 17 - 6 = 16 (for 0 indexed )

now add k / fact in ans --> 16 / 6 = 2 --> 0 index , means first digit is 3 
remove that digit from num and also update k = k % fact  --> 16 % 4 = 4
 now we have 1, 2, 4 left , so factorial should be n-1 which means 2! = 2
{1, 2, 4}, k = 4, fact = 2
repeat all steps again

and after some steps, our num will have been empty, then stop while loop and return ans 

*/