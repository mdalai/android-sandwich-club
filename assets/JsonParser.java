
import java.util.*;

public class JsonParser {
	
	public static HashMap parseJsonToHashmap(String s){
        HashMap<String,Object> hm = new HashMap<String,Object>();
        // A pointer that is used in LOOP
        int idx = 0;
        // HashMapy key
        String key;
        int start_idx = 0;
        int end_idx = 0;
        // Seperator index that seperate key and value
        int sep = 0; 
        
        // LOOP through the string
        while (s.indexOf('\"',idx+1) != -1) {
            // find the key
            start_idx = s.indexOf('\"',idx+1);
            end_idx = s.indexOf('\"',start_idx+1);
            key = s.substring(start_idx+1,end_idx);
            // find the value
            sep = s.indexOf(':',end_idx);
            // if a value is a list []
            if (s.substring(sep+1,sep+2).indexOf('[') != -1) {
                List<String> value = new ArrayList<String>();
                idx = s.indexOf('[',sep+1) + 1;
                while (idx >= s.indexOf('[',sep+1) && idx < s.indexOf(']',sep+1) ){
                    start_idx = s.indexOf('\"',idx);
                    end_idx = s.indexOf('\"',start_idx+1);
                    value.add(s.substring(start_idx+1,end_idx));
                    idx = end_idx + 1;
                }
                hm.put(key, value);
            }
            // if a value is a hashmap {}
            else if (s.substring(sep+1,sep+2).indexOf('{') != -1) {
                start_idx = s.indexOf('{',sep+1);
                int start = start_idx;
                end_idx = s.indexOf('}',start+1);
                while (s.substring(start+1,end_idx).indexOf('{') != -1 ){
                    start = s.indexOf('{',start+1);
                    end_idx = end_idx + 1;
                }
                end_idx = s.indexOf('}',end_idx);
                HashMap value = parseJsonToHashmap(s.substring(start_idx,end_idx+1));
                hm.put(key, value);
                idx = end_idx;

            }
            // if a value is a string
            else {
                start_idx = s.indexOf('\"',sep+1);
                end_idx = s.indexOf('\"',start_idx+1);
                String value = s.substring(start_idx+1,end_idx);
                hm.put(key, value);
                idx = end_idx;
            }
        }

        return hm;
    }

}
