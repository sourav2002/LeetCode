
class Pair{
    
    String stationName;
    int startTime;        
    public Pair(String s, int t){
        stationName = s;
        startTime = t;
    }
}


class UndergroundSystem {

    Map<Integer, Pair> checkInMap;
    Map<String, double[]> path; 
    
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        path = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) { 
        checkInMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair pair = checkInMap.get(id);
        int startT = pair.startTime;
        int endT = t;
        int totalT = endT-startT;
        String from = pair.stationName;
        String to = stationName;
        String sourceToDest = from +"-" + to;

        double[] data = path.getOrDefault(sourceToDest, new double[2]);
        data[0] += totalT;
        data[1]++;
        path.put(sourceToDest, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String sourceToDest = startStation +"-"+ endStation;
        double[] data = path.get(sourceToDest);
    
        double ans = data[0] / data[1];
        return ans;
    }
}
