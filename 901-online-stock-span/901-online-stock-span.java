class StockSpanner {

    Stack head;
    int res;
    public StockSpanner() {
        head = null;
        res = 1;
    }
    
    public int next(int price) {
        if(head == null){
            head = new Stack(price, res);
            return head.res;
        }
        Stack s = new Stack (price, 1);
        while(head != null && s.price >= head.price){
            s.res += head.res;
            head = head.next; //remove  || pop()
        }
        
        s.next = head;
        head = s;
        return head.res;
    }
    
    
    class Stack{
        Stack next;
        int price;
        int res;
        public Stack(int p, int r){
            price = p;
            res = r;
            next = null;
        }
    }
}
