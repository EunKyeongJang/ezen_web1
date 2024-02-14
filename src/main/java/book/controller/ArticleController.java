package book.controller;

import book.dao.ArticleDao;
import book.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//1. 스프링 컨테이너(메모리 저장소)에 빈(객체/힙) 등록 => 스프링이 해당 클래스를 사용할 수 있다
//2. 모든 클라이언트 요청은 컨트롤러로 들어온다.
@Controller
@Slf4j  //자바에서 간단한 로그처리
public class ArticleController {

    @Autowired  //스프링 컨테이너에 등록된 빈 주입한다.
    ArticleDao articleDao;

    //1. 글쓰기 페이지 반환
    @GetMapping("/articles/new") //HTTP 요청 경로 : GET방식 : localhost:8000/articles/new
    public String newArticleForm(){
        return "articles/new";   //.확장자 빼고 resources/tamplate 부터 경로 작성 /  : 자원
    }

    //2. 글쓰기 처리
    //1. <form action="/article/create" method="post">
    //2. 입력태그 속성의 name과 Dto 필드의 필드명 일치하면 자동 연결/대입 된다.
    //3. public 생성자 필요
    @PostMapping("/articles/create")    //HTTP요청경로 : POST방식 : localhost:8000/articles/create
    public boolean createArticle(ArticleForm form){
        //soutm : 메소드명 출력
        System.out.println("ArticleController.createArticle");
        //soutp : 매소드 매개변수 출력
        System.out.println("form = " + form);

        //개발용(디버그) 로그
        log.debug(form.toString());

        //경고용 로그
        log.warn(form.toString());

        //애러 로그
        log.error(form.toString());

        //운영(배포) 로그
        log.info(form.toString()); //자동완성 : 메뉴 -> 파일 -> 설정 ->pligIn -> 마켓플레이스

        //Dao 에게 요청하고 응답 받기
        boolean result=articleDao.createArticle(form);

        return result;
    }//m end

    //p.156 조회
        //[개별조회]
        //1. 클라이언트가 서버(spring) 요청시 id 전달
        //2. HTTP URL 이용한 요청 : /articles/1, /articles/2, /articles/3
        //정해진 값이 아닌 매개변수일 경우에는 : /articles/{매개변수명}/{매개변수명}/{매개변수명}
        //요청 : /articles / 1또는2또는3
        //3. 서버(sprig) Controller 요청 URL 매핑/연결 받기
        //4. @GetMapping("/articles/{매개변수}")
        //5. 함수 매개변수에서 URL 상의 매개변수와 이름 일치
        //6. 함수 매개변수 앞에 @PathVariable 어노테이션 주입
            //@PathVariable : URL 요청으로 들어온 전달값을 컨트롤러 함수의 매개변수로 가져오는 어노테이션
    @GetMapping("/articles/{id}")    //클라이언트 요청 예시 : /articles/1, /articles/2, /articles/3
    public String show(@PathVariable Long id, Model model){      //id : 1  or id : 2  or  id : 3
        System.out.println("id = " + id);
        //p.159 1. 요청된 id를 가지고 DB에게 데이터 요청 [JSP 대신에 DAO]
        ArticleForm form=articleDao.show(id);
        System.out.println("form = " + form);
        //p.160 2. DAO에게 전달받은 값을 뷰템플릿에게 전달하기 // model.addAttibute("키", "값")
        model.addAttribute("article", form);
        model.addAttribute("name", "유재석");
        //{{model 속성명}}
        //{{>파일경로}}
        //p.161 3. 해당 함수가 종료될 떄 리턴값 1.화면/뷰 (머스테치,HTML)  2.값 (JSON)
        return "articles/show";
    }//m end

    //p.170 조회
        //[전체조회]
    @GetMapping("/articles")
    public String index(Model model){
        //1. DAO에게 요청해서 데이터 가져온다.
        List<ArticleForm> result=articleDao.index();
        //2. p.175 뷰템프릿(머스테치)에게 전달할 값을 model에 담아준다.
        model.addAttribute("articleList",result);
        //3. p.185 뷰 페이지 설정
        return "articles/index";
    }


}//c end
/*
    자유도 떨어짐

    @ : 어노테이션
        1. 표준 어노테이션 : 자바에서 기본적으로 제공
            @Override : 메소드 재정의
            등등
        2. 메타 어노테이션 : p.64
            - 소스코드에 추가해 사용하는 메타데이터
            - 메타데이터 : 대량의 구조화된 데이터
            - 컴파일 또는 실행했을때 코드를 어떻게 처리해야할지 알려주는 정보
            @SpringBootApplication -> 동일 패키지 내의 아래 어노테이션 등을 자동으로 인식함
                - 1. 내장서버(톰캣) 지원 -> [순수 자바는 웹언어가 아니기 때문]
                - 2. 스프링MVC패턴 내장
                    view : resource
                    controller : @Controller, @RestController
                        serviece : @Serviece
                    modle(dao) : @Repository
                        entity(db table) : @Entity
                        그외별도 : @Component
                        설정클래스 : @Configuration
                    model : Dao
                - 2. 컴포넌트(model) 스캔 : MVC 클래스 스캔
            @Controller
            @GetMapping

 */
/*  - 상호작용 특징(다른 클래스의 함수 호출) >> [MVC 패턴은 클래스들이 분업하기 때문에 서로 다른 클래스들끼리 데이터 주고 (매개변수) 받는다(리턴)]
        1. 해당 함수가 인스턴스(static 없으면) 멤버이면
        ArticleDao articleDao=new ArticleDao();
        articleDao.createArticle();
        //2. 해당 함수가 인스턴스(static 없으면) 멤버이면
        new ArticleDao().createArticle();
        //3. 해당함수가 정적(static) 멤버이면
        ArticleDao.createArticle();
        //4. 해당 클래스가 싱글톤 (프로그램 내 무조건 하나의 객체만 갖는 패턴)
        ArticleDao.getInstance().createArticle();
 */
