package ezenweb.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.StringTokenizer;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class MemberDto {
    private int no;     //회원번호 input type="text" > int로 자동타입변환
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;

    //private String img;       //input type="text"(String)
    private MultipartFile img;  //type="file"(MultipartFile) 첨부파일 형식
    private String uuidFile;
}
