package example.day01.consoleMvc;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;

public class MainView {
    //필드
    Scanner scanner=new Scanner(System.in);
    private TodoController todoController=new TodoController();

    //1. 메인페이지
    public void home(){
        while(true){
            System.out.println("1. 할일등록 : ");
            int ch=scanner.nextInt();
            if(ch==1){
                doPost();   //할일 등록
            }//if end
            doGet();        //할일 출력
        }//w end
    }//m end

    //2. 할일 등록 함수
    public void doPost(){
        //1. 입력받기
        System.out.println("할일 내용 : ");
        String content=scanner.next();
        System.out.println("마감일[yyyy-mm-dd] : ");
        String deadLine=scanner.next();

        //2. 객체
        TodoDto todoDto=new TodoDto();
        todoDto.setContent(content);
        todoDto.setDeadline(deadLine);

        //3. 컨트롤에게 보내기
        boolean result=todoController.doPost(todoDto);

        //4. 응답결과 출력하기
        System.out.println(result);
    }//m end

    //3. 할일 목록 출력 함수
    public void doGet(){
        //1. 입력받기 - 전체 출력이라서 조건이 없음
        //2. 객체화x
        //3. 컨트롤에게 요청 응답 받기
        ArrayList<TodoDto> result=todoController.doGet();
        //4. 응답결과 출력하기
        for(int i=0; i<result.size(); i++){
            //i번째 Dto 호출
            TodoDto todoDto=result.get(i);
            System.out.printf(" %2s %10s %10s %10s \n",
                    todoDto.getId(),
                    todoDto.getDeadline(),
                    todoDto.isState(),
                    todoDto.getContent() );
        }//for end
    }//m end
}//c end
