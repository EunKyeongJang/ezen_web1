package book.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //*이 클래스가 컨트롤러임을 선언
public class FirstController {

    @GetMapping("/hi")  //http://localhost:8000/hi
    public String niceToMeetYou(Model model){//인수에 매개변수 선언
        //mustache에 전달한 매개변수 등록
        model.addAttribute("username","유재석");

        //return "머스테치파일명"
        return "greetings"; //서버가 알아서 templates 폴더에서 파일을 찾아 브라우저에게 전송.
    }

    @GetMapping("/bye") //외부 통신 방법 : HTTP이므로 http://localhost:8000/bye
    public String seeYouNext(Model model){
        //mustache에 전달한 매개변수 등록
        model.addAttribute("nickname","홍길동");

        //return "머스테치파일명"
        return "goodbye";
    }

    /*
    Get : 요청

    HTTP : 이동식 문서 교환 규약
        1. ip주소:port번호  ,  스프링아  ,  localhost:8000
        2./자원의 경로      ,  도서지금대장문서  ,  /bookdocument  ->  @GetMapping("/bookdocument") -> 해당함수로 이동

    브라우저 [클라이언트]                                    스프링Controller [서버]
    강호동                                                 신동엽 localhost:8000
                    강호동이 신동엽에게 도서지급대장문서를 줘    서랍 = hi [도서지급대장문서 = greetings.mustache]
                    http://localhost:8000/hi
                    --------------------------------->
    브라우저          신동엽이 강호동에게 도서지급대장문서를 응답
    html렌더링가능    String 문자[html]전송                 강호동은 템플릿을 모르니까 템플릿 HTML 렌더링하고 HTML로 반환
                    <---------------------------------

     */

}
