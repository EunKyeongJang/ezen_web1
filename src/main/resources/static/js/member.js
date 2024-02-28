console.log("member.js");

//1. 회원가입
function signup(){
    // *유효성검사 체크 현황중에 하나라도 false이변 회원가입 금지
    for(let i=0; i<checkArray.length; i++){
        if(!checkArray[i]){
            alert('입력사항들을 모두 정확히 입력 해 주세요');
            return;
        }
    }
    checkArray.indexOf;
    checkArray.includes();

    //1. 입력값 호출 입력값 호출 [document.querySelector()]
    //1. 데이터 하나씩 요청
    /*let id = document.querySelector('#id').value;             console.log(id);
    let pw = document.querySelector('#pw').value;             console.log(pw);
    let name = document.querySelector('#name').value;         console.log(name);
    let phone = document.querySelector('#phone').value;       console.log(phone);
    let email = document.querySelector('#email').value;       console.log(email);
    let img = document.querySelector('#img').value;           console.log(img);*/


    //2. 객체화 [let info={}]
        /*let info={
            id : id,
            pw : pw,
            name : name,
            phone : phone,
            email : email,
            img : img
        };
        console.log(info);*/

    //2. 폼 가져오기
        let signUpForm=document.querySelectorAll('.signUpForm');
    console.log(signUpForm);
    let signUpFormData=new FormData(signUpForm[0]);
            //FormData : 문자 데이터가 아닌 바이트 데이터로 변환(첨부파일 필수)
    console.log(signUpFormData);
    //--유효성 검사



    //3. 객체를 배열에 저장 ---> spring controller서버와 통신 [JQUERY AJAX]
    $.ajax({
            url : '/member/signup',
            method : 'POST',
            data : signUpFormData,
            contentType : false,
            processData : false,
            success : function (result){
                console.log(result);
    //4. 결과
                if(result){
                    alert('회원가입 성공');
                    location.href='/member/login'
                }
                else{
                    alert('회원가입 실패');
                }
            }
        })//a end
}//m end

//2. 로그인
function login(){
    console.log("login()");
    //1. HTML로부터 입력값 가져오기
    let id=document.querySelector('#id').value;     console.log(id);
    let pw=document.querySelector('#pw').value;     console.log(pw);

    //2. 객체화
    let info={id:id, pw:pw};
    console.log(info);

    //3. 서버와 통신
    $.ajax({
                url : '/member/login',          //어디에
                method : 'POST',                //어떻게
                data : info,                    //무엇을 보낼지, 입력받은값 보내기
                success : function (result){    //무엇을 받을지, 통신후 응답결과 받기
                    console.log(result);
        //4. 결과
                    if(result){
                        alert('로그인 성공');
                        //페이지 전환
                        location.href="/";  //로그인 성공 시 메인페이지로 이동
                    }
                    else{
                        alert('로그인 실패');
                    }
                }//success end
            })//a end

    //4. 결과

}

/*
onclick
onchange
*/

function onChangeImg(event){
   console.log('preimg');
   console.log(event);  //현재 함수를 실행한 input
   console.log(event.files); //현재 input의 첨부파일들
   console.log(event.files[0]); //첨부파일들 중에서 첫번째 파일

   //- input에 업로드된 파일을 바이트로 가져오기
        //new FileReader() : 파일읽기 관련 메소드 제공
   //1. 파일 읽기 객체 생성
   let file = new FileReader();
   //2. 파일 읽기 메소드
   file.readAsDataURL(event.files[0]);
   console.log(file);
   console.log(file.result);
   //3. 파일 inload 정의
   file.onload=e => {
       console.log(e);  //ProgressEvent
       console.log(e.target);
       console.log(e.target.result);    //여기에 읽어온 첨부파일 바이트
       document.querySelector('#preimg').src = e.target.result;
   }
}//m end
/*
    함수 정의 방법
    1. function 함수명(매개변수) {}
    2. function (매개변수) {}
        let 변수명 = function(매개변수) {}
        let 변수명 = {
            e : function(매개변수) {}
        }

    3. (매개변수) => {}
        let 변수명 = (매개변수) => {}


*/
/*
        onclick     : 클릭할때마다
        onchange    : 값이 변경될때마다
        onkeyup     : 키보드 키를 떼었을때

        -------정규표현식------
        정규표현식이란 : 특정한 규칙을 가진 문자열의 집합을 표현할 떄 사용하는 형식 언어
        - 주로 문자열 데이터 검사할 떄 사용 - 유효성검사
        - 메소드

        - 형식규칙
            /^ : 정규표현식 시작 알림
            $/ : 정규표현식 끝 알림
            {최소길이, 최대길이} : 문자 길이 규칙
            [허용할 문자/숫자] : 허용문자 규칙
                [a-z] : 소문자 a~z 허용
                [a-zA-Z] : 영 대소문자 a-z 허용
                [a-zA-Z0-9] : 영 대소문자, 숫자 허용
                [a-zA-Z0-9가-힣] : 영 대소문자, 숫자, 한글 허용
        +   : 앞에 있는 페턴 1개 이상 반복
        ?   : 앞에 있는 패턴 0개 혹은 1개 이상 반복
        *   : 앞에 있는 패턴 0개 반복
            [A-Za-z]            
        .   : 1개 문자
            (?=.*[1개 이상 문자 패턴])
        ()  : 패턴의 그룹
        ?=.*: 앞에 있는 패턴 문자 존재 여부 판단

        예1) /^[a-z0-9]{5,30}$/
            영 소문자와 숫자 조합의 5~30글자 허용
        예2) /^[A-Za-z0-9]{5,30}$/
            영 대소문자와 수자 조합의 5~30 글자 허용
        예3) (?=.*[A-Za-z]) ((?=.*[0-9]) [A-Za-z0-9]{5,30}
            영 대소문자 1개 이상 필수, 숫자 1개 이상 필수
        예4) /^[가-힣]{5,20}$/
            한글 5~10 글자
        예5) 000-0000-0000 또는 00-000-0000
            /^ ([0-9]{2,3})+[-]+([0-9]{3,4})+[-]+([0-9]{4}) $/
        예6)문자열@문자.문자
            [a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]
            

*/

//************현재 유효성검사 체크 현황 */
let checkArray = [false,false,false,false,false];   //아이디, 비밀번호, 이름, 전화번호, 이메일

//4. 아이디 유효성검사(아이디 입력할 때 마다)
function idCheck(){
    console.log(`idCheck()`);

    //1. 입력된 데이터 가져오기
    let id=document.querySelector('#id').value;
    console.log(id);

    //2. 정규 표현식 : 영소문자+숫자 조합의 5~30 글자 사이 규칙
    let 아이디규칙=/^[a-z0-9]{5,30}$/

    //3. 정규표현식에 따른 검사
    console.log(아이디규칙.test(id));
    if(아이디규칙.test(id)){        
        //*아이디 중복체크(ajax)
        $.ajax({    //비동기 vs 동기
            url : "/member/find/idcheck",
            method : "get", //http body 없다. -> 쿼리스트링
            data : {"id" : id}, //`/member/find/idcheck?id=${id}
            success : (r) => {
                if(r){
                    document.querySelector('.idcheckbox').innerHTML=`사용중인 아이디`;
                    checkArray[0]=false; //체크 현황 변경
                }
                else{
                    document.querySelector('.idcheckbox').innerHTML=`통과`;
                    checkArray[0]=true; //체크 현황 변경
                }
            }//s end
        })//a end

    }
    else{
        //유효성검사 결과 출력
        document.querySelector('.idcheckbox').innerHTML=`영소문자+숫자 조합의 5~30 글자를입력해주세요`;
        checkArray[0]=false; //체크 현황 변경
    }
}

//5. 패스워드 유효성 검사
function pwcheck(){
    console.log("pwcheck");

    //1. 입력값 가져온다
    let pw=document.querySelector('#pw').value;
    let pwconfirm=document.querySelector('#pwconfirm').value;

    let msg="";
    checkArray[1]=false;    

    //2. 유효성 검사
    //1. 비밀번호에 대한 정규표현식 : 영대소문자 1개 필수와 숫자 1개 필수의 조합 5~30
    let 비밀번호규칙=/^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,30}$/

    //2. 
    if(비밀번호규칙.test(pw)){
        if(비밀번호규칙.test(pwconfirm)){
            if(pw==pwconfirm){
                msg="통과";
                checkArray[1]=true;
            }
            else{
                msg='패스워드 불일치';
            }
        }
        else{
            msg="영대소문자 1개 필수와 숫자 1개 필수의 조합 5~30글자"
        }
    }
    else{
        msg="실패";
    }

        //2. 비밀번호와 비밀번호확인 동일한지 비교
    
    document.querySelector('.pwcheckbox').innerHTML=msg;
}//m end

//6. 이름 유효성 검사
function namecheck(){
    let name=document.querySelector('#name').value; //1. 입력값 가져온다.
    let 이름규칙=/^[가-힣]{5,20}$/                   //2. 정규표현식 작성한다.
    let msg="";
    checkArray[2]=false;

    if(이름규칙.test(name)){                        //3. 정규표현식 검사한다.
        msg="통과";                                 //4. 정규표현식 검사가 일치했을떄
        checkArray[2]=true;
    }
    else{
        msg='한글 5~20 글자';
    }
    document.querySelector('.namecheckbox').innerHTML=msg;
}

//7. 전화번호 유효성검사 : 
function phonecheck() {  
    let phone=document.querySelector('#phone').value;
    let 전화번호규칙= /^([0-9]{2,3})+[-]+([0-9]{3,4})+[-]+([0-9]{4})+$/;

    let msg='000-0000-0000 또는 00-000-0000';
    checkArray[3]=false;

    if(전화번호규칙.test(phone)){
        msg='통과';
        checkArray[3]=true;
    }
    document.querySelector('.phonecheckbox').innerHTML=msg;

}//m end

//8. 이메일 유효성검사 : 
function emailcheck() {  
    let email=document.querySelector('#email').value;
    let 이메일규칙= /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/;

    let msg='아이디@도메인 입력해 주세요';
    checkArray[4]=false;

    if(이메일규칙.test(email)){
        msg='통과';
        checkArray[4]=true;
    }
    document.querySelector('.emailcheckbox').innerHTML=msg;

}//m end