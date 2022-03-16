class Solution {
    public String convert(String s, int numRows) {
        
        // create string buiilder array
        StringBuilder [] sb = new StringBuilder[numRows];
        for(int i =0; i< numRows; i++){
            sb[i] = new StringBuilder();
        }
        
        //define variables
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;
        
        while(index < n){
            
            //Go down
            for(int i= 0; i< numRows && index < n; i++){
                sb[i].append(arr[index++]);
            }
            
            //Go up
            for(int j = numRows-2; j>0 && index < n; j--){
                sb[j].append(arr[index++]);
            }
        }
        
        // combine all stringbuilder 
        StringBuilder ans = sb[0];
        for(int i=1; i< sb.length; i++){
            ans.append(sb[i].toString());
        }
        
        return ans.toString();
    }
}