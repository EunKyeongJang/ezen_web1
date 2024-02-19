package ezenweb.controller;

import ezenweb.model.dto.LoginDto;
import ezenweb.model.dto.MemberDto;
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
        boolean result=true; //dao처리
        return result;  //dao 요청 후 응답 결과 보내기
    }

    //================= 2. 로그인 처리요청 =================
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
        boolean result=true;  //dao처리
        return result;   //dao 요청 후 응답 결과 보내기
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
