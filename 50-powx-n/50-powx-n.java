class Solution {
    public double myPow(double x, int n) {
         double ans = 1.0;
        long nn = n; //duplicate n(power) because we are going to modify it (nn/2)
        if(nn<0) {   // if the power is negative than make it + by multiplying with -1
            nn = -1 * nn;
        }

        while (nn > 0){
            if (nn % 2  == 1){ //if  the power is odd
                ans = ans * x;
                nn = nn-1;
            }else{ // if the power is even
                x = x * x;
                nn = nn / 2;
            }
        }

        if( n < 0){  // if the power was a negative number
            ans =  1 / ans;
        }
        return ans;
    }
}