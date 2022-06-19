class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList();
        Arrays.sort(products);
        String s = "";
        for(int i=0; i<searchWord.length(); i++){
            char c = searchWord.charAt(i);
            s += c;
            List<String> row = new ArrayList();
            int cnt = 0;
            for(int j = 0; j<products.length; j++){    
                if(products[j].startsWith(s)){
                    row.add(products[j]);
                    cnt++;
                }
                
                if(cnt == 3){
                    break;
                }
            }
            list.add(row);
        }
        return list;
    }
}