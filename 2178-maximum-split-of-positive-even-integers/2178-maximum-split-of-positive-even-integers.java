class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if(finalSum % 2 != 0)return List.of();
        long s = finalSum;
        List<Long> list = new ArrayList<>();
        for(long h = 2;s >= h;h+=2){
            list.add(h);
            s -= h;
        }
        System.out.println(list);
        list.set(list.size()-1, list.get(list.size()-1) + s);
        System.out.println(s);
        System.out.println(list);
        return list;
    }
}
/*
dry run - n = 28
h = 2 , n = 28, list=[2], n=n-h or n = 28-2
h = 4 , n = 26, list-[2,4], n = 26-4
h = 6 , n = 22, list=[2,4,6], n = 22-6
h = 8 , n = 16, list=[2,4,6,8], n = 16-8
h= 10, n = 8 STOP h > n

final list=[2,4,6,8]
add current s in last element
current s = 8,  list=[2,4,6,(8+8)]
return list;
*/