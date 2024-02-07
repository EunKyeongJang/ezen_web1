package example.day03.webMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//- ----------스프링부트 실행에 관련 기능 주입 ----------
//1. 내장 서버(톰캣) 진행
//******* 2. 동등한 패키지 또는 하위패키지
//@Controller / @RestController 들을 실행
public class AppStart {
    public static void main(String[] args) {
        //*스프링 시작
        SpringApplication.run(AppStart.class);
    }
}//c end
