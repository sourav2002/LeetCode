public class Codec {

    Map<String, String> map = new HashMap();
    String host = "http://tinyurl.com/";
    
    public String hashing(String longUrl){
        String hashcode = "";
        for(int i=0; i<6; i++){
            int random = (int)Math.random() % 3;
            
            if(random == 0) hashcode += '0' + Math.random() % 10;
            else if(random == 1) hashcode += 'a' + Math.random() % 26;
            else  hashcode += 'A' + Math.random() % 26;
        }
        
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
