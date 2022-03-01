class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        //initially string builder is empty and in every iteration a is appended and increment count
        System.out.println(count);
        if(sb.toString().contains(b)) return count;
        if(sb.append(a).toString().contains(b)) return ++count;
        return -1;
    }
}