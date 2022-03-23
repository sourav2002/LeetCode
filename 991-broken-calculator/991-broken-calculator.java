class Solution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            Y = Y % 2 > 0 ? Y + 1 : Y / 2;
            res++;
        }
        // here we are adding x -y in our result because when y become less than x, then we only can perform add operaton on y so just simplly return the diff between x and y 
        return res + X - Y;
    }
}