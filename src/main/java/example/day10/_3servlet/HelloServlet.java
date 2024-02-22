package example.day10._3servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//자바 회사에서 웹개발위한 HTTP 통신 클래스 : HttpServlet
    // : mvc 패턴에서는 주로 controller 역할
    //1. 해당 클래스에 HttpServlet 상속받는다.
    //2. 해당 클래스에 @WebServlet("HTTP 식별주소") 어노테이션 주입해서 web.html에 등록한다.
    //3. HTTP가 제공하는 메소드를 오버라이딩 : init(), service(), doXXX(), destory()

    //서블릿 실행 구동 순서
    //1. 클라이언트(브라우저)HTTP 요청(톰캣 서버)이 들어온다.
    //2. 서블릿컨테이너에 요청받은 서블릿이 있는지 없는지 판단
    //3. 없으면 init() 메소드 실행한 서블릿 생성
    //4. 있으면 또는 생성했으면 Thread(작업스레드) 할당
    //5. service() 실행하고 HTTP요청 메소드에 따른 메소드로 이동
    //6. doGet / doPost / (do OOO) 메소드 실행될 때 요청(HttpServletRequest) 객체 생성
    //7. doGet / doPost / (do OOO) 메소드 종료될 때 응답(HttpServletResponse) 객체 생성
    //-------------- 다음 요청이 올때까지
    //1 -> 2 -> 4 -> 5

    //-------------- 서버가 종료되면 destory() 실행되면서 안전하게 서블릿 제거

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    //HttpServlet 클래스로 부터 상속받으면 다양한 HTTP 관련 메소드 사용

    @Override   //1. [최초요청 1번 실행] 해당 서블릿 객체(서버당 1개)가 생성되었을 때 실행되는 메소드
    public void init() throws ServletException {
        System.out.println("HelloServlet.init");
        super.init();
    }

    @Override   //2. [요청마다 실행] 해당 서블릿으로부터 HTTP 서비스 실행 되었을때 실행되는 메소드
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        super.service(req, resp);   //http get/post 판단
    }

    @Override   //3. [HTTP 메소드에 따라 실행] HTTP서비스 요청중에 HTTP method 방식이 get이면 실행되는 메소드
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doGet");
        super.doGet(req, resp);
    }

    @Override   //[HTTP 메소드에 따라 실행]
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doPost");
        super.doPost(req, resp);
    }

    @Override   //4. [서버가 종료될 때 1번 실행] 해당 서블릿 객체가 삭제되었을때 실행되는 메소드
    public void destroy() {
        System.out.println("HelloServlet.destroy");
        super.destroy();
    }
}
