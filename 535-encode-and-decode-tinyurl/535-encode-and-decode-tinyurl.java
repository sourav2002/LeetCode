public class Codec {

    Map<String, String> map = new HashMap();
    String host = "http://tinyurl.com/";
    Random rand = new Random();
    
    public String hashing(String longUrl){
        String hashcode = "";
        for(int i=0; i<6; i++){
            int random = rand.nextInt(3);
            if(random == 0) hashcode += (char)(rand.nextInt(10) + '0');
            else if(random == 1) hashcode +=(char) (rand.nextInt(26)+ 'a');
            else  hashcode +=(char) (rand.nextInt(26)+'A');
        }
        
        System.out.println(hashcode);
        if(map.containsKey(hashcode)){
            return hashing(longUrl);
        }else{
            map.put(hashcode, longUrl);
            return hashcode;
        }
    }

    public String encode(String longUrl) {
        String code = hashing(longUrl);
        return host+code;
    }

    public String decode(String shortUrl) {
        String hashcode = shortUrl.replace(host, "");
        return map.get(hashcode);
    }
}
