package ezenweb.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service    //빈 등록
public class EmailService {
    //SMTP : 간이 우편 정송 프로토콜 (메일전송)
        //- 자바에서 메일보내기
        //1. SMTP 라이브러리 필요 https://start.spring.io/
        //2. Dependencies : Java Mail Sender
            //implementation 'org.springframework.boot:spring-boot-starter-mail'
        //3. 이메일 전송
            //1. 이메일 내용을 구성 => 구성 포멧 ㅣ MIME (SMTP 사용할 때 사용되는 포맷)
        //4. 보내는 사람 이메일 인증


    //1. java(spring) 지원하는 smtp 객체 필요 = javaMailSender
    @Autowired
    private JavaMailSender javaMailSender;  //java mail 제공하는 객체

    public void send(){
        try {
            // * 메일 내용물들을 포맷하기 위한 MiME 형식 객체
            MimeMessage message = javaMailSender.createMimeMessage();
            //1. 메일 기본 구성
            //MimeMessageHelper(mime객체, 첨부파일 여부, 인코딩 타입(utf-8 등)); : 내용물 구성
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "utf-8");
            //2. 메일 보내는사람
            mimeMessageHelper.setFrom("jjjang1030@naver.com");  //관리자 이메일
            //3. 메일 받는사람
            mimeMessageHelper.setTo("jjjang1030@naver.com");  //클라이언트(회원) 이메일(매개
            //4. 메일 제목
            mimeMessageHelper.setSubject("자바에서 보내온 메세지");   //매개변수
            //5. 메일 내용
            mimeMessageHelper.setText("안녕하세요 내용입니다.");      //매개변수
            //메일 전송
            javaMailSender.send(message);
        }
        catch (Exception e){
            System.out.println("e : "+e);
        }
    }//m end
}//c end
