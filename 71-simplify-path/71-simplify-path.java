class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String [] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(!arr[i].equals(".") && !arr[i].equals("")){
                st.push(arr[i]);
            }
        }
        if(st.isEmpty()) return "/";
        while(!st.isEmpty()){
            sb.insert(0, st.pop()).insert(0,"/");
        }
        
        return sb.toString();
    }
}