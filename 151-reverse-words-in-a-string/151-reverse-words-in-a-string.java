class Solution {
    public String reverseWords(String s) {
        
        StringBuffer ans = new StringBuffer();
        int i = 0;
        while(s.charAt(i) == ' '){
            i++;
        }
        s =s.substring(i, s.length());
        if(s.length() == 1){
            return s;
        }
        System.out.println(s);
        int n = s.length() -1 ;
        while( n != 0){
            System.out.println("initially : "+n);
            StringBuffer word = new StringBuffer();
            while( n > 0 && s.charAt(n) == ' '){
                n--;
            }
            System.out.println("if contain any space then after removing, n = " + n);
            while(n > 0 && s.charAt(n) != ' '){
                word.append(s.charAt(n));
                n--;
            }
            
            if(n == 0 && s.charAt(0) != ' '){
                word.append(s.charAt(0));
            }
            
            System.out.println("after adding char in word, n = "+ n);
            System.out.println("before reverse = "+ word);
            word.reverse();
            System.out.println("after reverse = "+ word);
            ans.append(word);
            if(n !=0 ){
               ans.append(' '); 
            }
                        
            System.out.println("after appending with ans = "+ ans);
            System.out.println();
            System.out.println();
            System.out.println();
        }
        System.out.println("final ans is = "+ ans.toString());
        return ans.toString();
    }
}