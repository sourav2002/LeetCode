class Solution {
    public boolean isPowerOfTwo(int n) {
        // Size of an integer is assumed to be 32 bits
        // if(n == 1){
        //     return true;
        // }
//         String s = "";
//         for (int i = 31; i >= 0; i--) {
//             int k = n >> i;
//             if ((k & 1) > 0)
//                 s+= 1;
//             else
//                 s+=0;
//         }
//         String result = removeLeadingZeroes(s);
//         int len = result.length();
//         System.out.println(s);
//         System.out.println(Math.pow(2, len -1));
//         if(Math.pow(2, len-1) == n){
//             return true;
//         }
        
//         return false;
//     }
//        public static String removeLeadingZeroes(String str) {
//       String strPattern = "^0+(?!$)";
//       str = str.replaceAll(strPattern, "");
//       return str;
        return (n>0) && (n & n - 1) == 0;
   }
}