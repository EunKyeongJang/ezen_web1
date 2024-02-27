package ezenweb.service;

import ezenweb.model.dao.MemberDao;
import ezenweb.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    FileService fileService;    //외부 서비스
    @Autowired
    MemberDao memberDao;

    //1. 회원가입 서비스
    public boolean doPostSignup(MemberDto memberDto){
        //1. 파일처리
        String filename = fileService.fileUpload(memberDto.getImg());
        if(filename!=null){//업로드 성공 했으면
            //2.DB처리
            //dto에 업로드 성공한 파일명을 대입한다.
            memberDto.setUuidFile(filename);
            memberDao.doPostSignup(memberDto);
        }
        return false;
    }//m end
}//c end
