package example.day10._3인servlet실습;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication  //아파치 톰캣 : 자바 서블릿 실행 -> 서블릿 컨테이너가 있어 객체를 저장해 놓는다.
@ServletComponentScan    //서블릿 찾는다.
public class SpringBootStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class);
    }
}
