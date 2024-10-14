package shop.mtcoding.todayhome.core.util;

import java.util.Base64;

public class Base64Util {

    // image/jpeg 중에 jpeg 만 return
    // MIME 타입 파일 확장자 추출(png, jpg 등)
    public static String getMimeType(String imgBase64){
        int beginIndex = imgBase64.indexOf("/")+1;
        int endIndex = imgBase64.indexOf(";");
        String mimeType = imgBase64.substring(beginIndex, endIndex);
        return mimeType;
    }

    // 인코딩 작업은 필요없음, 인코딩 된 base64 를 받아서 디코딩만 하면 됨
//    public static String encodeAsString(byte[] imgBytes, String mimeType){
//        String imgBase64 = Base64.getEncoder().encodeToString(imgBytes);
//        imgBase64 = "data:$mimeType;base64,$imgBase64".replace("$mimeType", mimeType).replace("$imgBase64", imgBase64);
//        return imgBase64;
//    }

    public static byte[] decodeAsBytes(String imgBase64){
        // 1. mimetype parsing
        String mimeType = getMimeType(imgBase64);
        //System.out.println(mimeType);

        // 2. img parsing
        int prefixEndIndex = imgBase64.indexOf(",");
        String img = imgBase64.substring(prefixEndIndex+1);
        //System.out.println(img);

        // 3. base64 decode to byte[]
        byte[] imgBytes = Base64.getDecoder().decode(img);
        return imgBytes;
    }
}
