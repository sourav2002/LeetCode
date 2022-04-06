class Solution {

    class Node {
        Node[] child;
        int cnum;

        public Node() {
            child = new Node[2];
            cnum = 0;
        }
    }
    
    
    public void insert(Node root, int num){
        
        Node cur = root;
        for(int i=30; i>= 0; i--){
            int bit = (num >>> i) & 1;
            if(cur.child[bit] == null){
                cur.child[bit] = new Node();
            } 
            cur = cur.child[bit];
        }
        cur.cnum = num;
    }
    
    public int search(Node root, int num){
        Node cur = root;
        for(int i =30; i>= 0; i--){
            int bit = (num >>> i) & 1;
            if(cur.child[1-bit] != null){
                cur = cur.child[1-bit];
            }else{
                cur = cur.child[bit];
            }
        }
        
        return cur.cnum ^ num;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Node root = new Node();
        int qlen = queries.length;
        int ans[] = new int[qlen];
        
        Arrays.sort(nums);
        int[][] offlineQueries = new int[qlen][3]; // last index store the index value of querie
        for(int i=0; i< qlen; i++){
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }
        
        Arrays.sort(offlineQueries, (o1, o2) -> {
            return (o1[1] - o2[1]); 
        });
        
        int index = 0;
        for(int[] q : offlineQueries){
            
            // insert nums less then offquerie val at 1st index
            while (index < nums.length && nums[index] <= q[1]) {
                insert(root, nums[index]);
                index++;
            }
            
            int tempAns = -1;
            // if i is 0 means no number in nums array is smaller then given querie value
            if( index != 0){
                tempAns = search(root, q[0]);
            }
            
            ans[q[2]] = tempAns;
        }
        return ans;
    }
}
