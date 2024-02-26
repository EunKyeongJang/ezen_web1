console.log("member.js");

//1. 회원가입
function signup(){
    //1. 입력값 호출 입력값 호출 [document.querySelector()]
    let id = document.querySelector('#id').value;             console.log(id);
    let pw = document.querySelector('#pw').value;             console.log(pw);
    let name = document.querySelector('#name').value;         console.log(name);
    let phone = document.querySelector('#phone').value;       console.log(phone);
    let email = document.querySelector('#email').value;       console.log(email);
    let img = document.querySelector('#img').value;           console.log(img);
    //--유효성 검사

    //2. 객체화 [let info={}]
    let info={
        id : id,
        pw : pw,
        name : name,
        phone : phone,
        email : email,
        img : img
    };
    console.log(info);

    //3. 객체를 배열에 저장 ---> spring controller서버와 통신 [JQUERY AJAX]
    $.ajax({
            url : '/member/signup',
            method : 'POST',
            data : info,
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
}

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