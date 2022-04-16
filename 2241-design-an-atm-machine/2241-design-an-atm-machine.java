class ATM {

     int[] value;
     long[] count;
    public ATM() {
        value = new int[]{ 20,50,100,200,500};
        count = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0; i< banknotesCount.length; i++ ){
            count[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        long ans[] = new long[5];
        int index = 4;
        while(index >= 0 && amount > 0){
            long takenote = Math.min(amount / value[index],  count[index]);
            ans[index] = takenote;
            amount -= takenote * value[index];
            index--;
        }
        
        if(amount != 0){
            return new int[]{-1};
        }
        else{
            for(int i=0; i<5; i++){
                count[i] = count[i] - ans[i];
            }
            return Arrays.stream(ans).mapToInt(i -> (int) i).toArray();
        }
    }
}