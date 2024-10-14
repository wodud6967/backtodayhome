package shop.mtcoding.todayhome.core.util;

import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.todayhome.core.error.ex.ExceptionApi500;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class MyFile {

    public static String 파일저장(MultipartFile file) {
        UUID uuid = UUID.randomUUID(); // UUID 를 통해 파일 이름을 고유하게 만들어 충돌 방지
        String fileName = uuid+"_"+file.getOriginalFilename(); // 롤링

        Path imageFilePath = Paths.get("./images/"+fileName); // 파일 경로 설정
        try {
            Files.write(imageFilePath, file.getBytes()); // imageFilePath 경로에 file.getBytes() 해당 파일을 실제로 저장
        } catch (Exception e) {
            throw new ExceptionApi500("파일 저장 오류");
        }
        return fileName; // 고유한 파일명 반환

    }
}
