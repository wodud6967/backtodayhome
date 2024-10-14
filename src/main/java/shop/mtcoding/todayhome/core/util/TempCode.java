package shop.mtcoding.todayhome.core.util;

import java.util.HashMap;
import java.util.Map;

public class TempCode {
    // code , tid
    private static Map<String, String> payCode = new HashMap<>();

    public static void addTid(String key, String tid){
        payCode.put(key, tid);
    }

    public static String getTid(String key){
        return payCode.get(key);
    }
}
