package shop.mtcoding.todayhome.core.util;

import shop.mtcoding.todayhome.core.error.ex.ExceptionApi500;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class MyFileUtil {

    public static String 파일저장(String imgBase64) {

        try {
            // file folder path
            String folder = "./images/"; // . 붙이는거 맞는지?

            // 1. 파일명 생성
            UUID uuid = UUID.randomUUID(); // UUID 를 통해 파일 이름을 고유하게 만들어 충돌 방지
            String mimeType = Base64Util.getMimeType(imgBase64); // 확장자
            String imgFileName = folder + uuid + "." + mimeType; // 파일 이름

            // 2. base64 -> byte[]
            byte[] imgBytes = Base64Util.decodeAsBytes(imgBase64); // base64로 인코딩된 이미지 제이터를 디코딩하여 바이트 배열로 변환, 이 바이트 배열이 실제 이미지 데이터

            // 3. 파일 쓰기
            Path imgFilePath = Paths.get(imgFileName); // 파일 저장 경로 지정 ("." -> 상대경로)
            Files.write(imgFilePath, imgBytes); // 이미지 바이트 데이터를 지정된 경로에 파일로 쓰기

            return imgFileName;

        } catch (Exception e) {
            throw new ExceptionApi500("이미지 저장 오류 : " + e.getMessage());
        }

    }
}
