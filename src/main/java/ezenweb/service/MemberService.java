package ezenweb.service;

import ezenweb.model.dao.MemberDao;
import ezenweb.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class MemberService {
    @Autowired
    FileService fileService;    //외부 서비스
    @Autowired
    MemberDao memberDao;
    @Autowired
    EmailService emailService;

    //1. 회원가입 서비스
    public boolean doPostSignup(MemberDto memberDto){
        /*
            만약,
            1. 첨부파일 있다 vs 없다.
                있다 [업로드 성공 vs 실패]
                    성공 DB처리
                    실패 무산 false
                없다
                    db처리
         */
        
        //1. 파일처리
            //만약에 첨부파일이 존재하면
        String filename="free.jpg";

        System.out.println("memberDto = " + memberDto);
        if(!memberDto.getImg().isEmpty()) {
            filename = fileService.fileUpload(memberDto.getImg());
            if (filename != null) {//업로드 성공 했으면

                //2.DB처리
                //dto에 업로드 성공한 파일명을 대입한다.
            }
            else {
                return false;   //업로드 실패했으면 회원가입 실패
            }
        }
        memberDto.setUuidFile(filename);
        boolean result=memberDao.doPostSignup(memberDto);

        if(result){
            emailService.send();
        }

        return result;
    }//m end

    //2. 로그인 서비스
    //3. 회원정보 요청 서비스
    public  MemberDto doGetLoginInfo(String id){
        //1.Dao호출

        return memberDao.doGetLoginInfo(id);
    }

    //4. ==================아이디 중복 체크 요청==================
    @GetMapping("/member/find/idcheck")
    @ResponseBody
    public boolean doGetFindIdCheck(@RequestParam String id){
     return memberDao.doGetFindIdCheck(id);
    }
}//c end
