package ezenweb.controller;

import ezenweb.model.dao.MemberDao;
import ezenweb.model.dto.LoginDto;
import ezenweb.model.dto.MemberDto;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    //1단계. V <----> C 사이의 HTTP통신방식 설계
    //2단계. Controller mapping 함수 선언하고 통신 체크 (API server)
    //3단계. Controller request 매개변수 매핑
        //-------- Dto, Service ----------
    //4단계. 응답 : 1. 뷰 반환 : text/html;  vs  2. 데이터 : @ResponseBody Application/JSON

    @Autowired
    MemberDao memberDao;

    //================= 1. 회원가입 처리요청 =================
    @PostMapping("/member/signup")   //http://localhost:8000/member/signup
    @ResponseBody   //응답 방식 : Application/JSON
    public boolean doPostsignup(MemberDto memberDto){
        /*
            params
            id, pw, name, email, phone, img
         */
        System.out.println("MemberController.signup");
        System.out.println("memberDto = " + memberDto);
        //--dao
        boolean result=memberDao.doPostSignup(memberDto); //dao처리
        return result;  //dao 요청 후 응답 결과 보내기
    }


    //*http 요청 서블릿 객체
    @Autowired
    private HttpServletRequest request;


    //================= 2. 로그인 처리요청 / 섹션 저장 =================
    @PostMapping("/member/login")   //http://localhost:8000/member/login
    @ResponseBody   //응답 방식 : Application/JSON
    public boolean doPostlogin(LoginDto loginDto){
        /*
            params
            id, pw
         */
        System.out.println("MemberController.login");
        System.out.println("loginDto = " + loginDto);
        //--
        boolean result=memberDao.doPostLogin(loginDto);  //dao처리

        //로그인 성공 시
            //섹션 저장소 : 톰캣 서버에 **브라우저 마다의 메모리 할당(다른 브라우저 메모리 연동은 안됨)
            //섹션 객체 타입 : Object (여러가지 타입들을 저장하려고)
            //1. http 요청 객체 호출      HttpServletRequest
            //2. http 섹션 객체 호출      .getSession()
            //3. http 섹션 데이터 저장     .setAttribute("세션명", 데이터);  -- 자동변환(자 -> 부)
            //-. http 섹션 데이터 호출     .getAttribute("섹션 속성명");     -- 강제변환(부 -> 자)
            //-. htto 섹션 초기화         .invalidate()
        if(result) {    //만약에 로그인 성공이면 섹션 부여
            request.getSession().setAttribute("loginDto", loginDto.getId());   //loginDto : 3
        }
        return result;   //dao 요청 후 응답 결과 보내기
    }//f end


    //2-2 ===========로그인 여부 확인 요청 / 섹션 호출=============
    @GetMapping("/member/login/check")
    @ResponseBody
    public String doGetLoginCheck(){
        //* 로그인 여부 확인 = 섹션이 있다 없다 확인
            //1. http 요청 객체 호출
            //2. http 섹션 객체 호출
            //3. http 섹션 데이터 호출
        //null은 형변환이 불가능하기 때문에 유효성검사 필요
        String loginDto=null;
        Object sessionObj=request.getSession().getAttribute("loginDto");
        if(sessionObj != null){
            loginDto=(String)sessionObj;
        }
        //만약에 로그인했으면(세션에 데이터가 있으면 ) 로그인정보 반환
        return loginDto;
    }//f end


    //2-3 ===========로그인 로그아웃 섹션 초기화=============
    @GetMapping("/member/logout")
    @ResponseBody
    public boolean doGetLogOut(){
        //1. 로그인 관련 섹션 초기화
            //1. 모든 섹션 초기화 (모든 섹션의 속성이 초기화 -> 로그인 섹션 외 다른 섹션도 고)
            request.getSession().invalidate();  //현재 요청 보낸 브라우저의 섹션 초기화

            //2. 특정 섹션 속성 초기화 => 동일한 섹션속성명에 null 대입한다.
            //request.getSession().setAttribute("loginDto", null);

        return true;
        //로그아웃 성공 시  => 메인페이지 또는 로그인페이지로 이동
    }


    //================= 3. 회원가입 페이지 요청 =================
    @GetMapping("/member/signup")
    public String viewSignup(){
        System.out.println("MemberController.viewSignup");
        return "ezenweb/signup";
    }


    //================= 4. 로그인 페이지 요청 =================
    @GetMapping("/member/login")
    public String viewLogin(){
        System.out.println("MemberController.viewLogin");
        return "ezenweb/login";
    }


    //================= 5. 회원수정 페이지 요청 ================
    @GetMapping("/member/update")
    public String viewUpdate(){
        System.out.println("MemberController.memberUpdate");
        return "ezenweb/update";
    }


    //================= 6. 회원수정 처리 요청 ================
    @PostMapping("/member/update")
    @ResponseBody   //응답 방식 : Application/JSON
    public boolean doPostupdate(MemberDto memberDto){
        System.out.println("MemberController.doPostupdate");
        System.out.println("memberDto = " + memberDto);
        boolean result=true;
        return result;
    }

}//c end
