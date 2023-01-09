class Solution {
    boolean isColinear(int p1[],int p2[],int p3[]){
        return (p2[1] - p1[1]) * (p3[0] - p2[0]) == (p2[0] - p1[0]) * (p3[1] - p2[1]);
    }
    public int maxPoints(int[][] points) {
        int ans = 1;
        for(int i = 0;i < points.length;i++){
            for(int j = i + 1;j < points.length;j++){
                int cnt = 2;
                for(int k = j + 1;k < points.length;k++){
                    if(k != i && k != j && isColinear(points[i],points[j],points[k])){
                        ++cnt;
                    }
                }
                ans = Math.max(ans,cnt);
            }
        }
        return ans;
    }
}