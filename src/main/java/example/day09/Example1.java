package example.day09;

import java.awt.*;

public class Example1 {

    //main 함수 안에는 main 스레드 포함
    public static void main(String[] args) {
        //1. 현재 코드의 스래드 객체 호출
            //Thread.currentThread();
        Thread thread=Thread.currentThread();
        //2. 현재 코드를 실행하는 스레드 객체의 이름
        System.out.println("1 thread.getName() : "+thread.getName());

        //3. 작업스레드 생성 4가지 방법
            //자식 익명객체 : 부모타입 변수명=new 부모타입(){ 재정의; }
        for(int i=1; i<=3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() { //- *1. 작업스레드가 실행할 댸 최초로 실행되는 함수 재정의
                    //Thread.currentThread();
                    Thread thread = Thread.currentThread();
                    //*3. 스레드 이름 변경
                    thread.setName("내가만든 작업 스레드");  //다른 스레드이기 때문에 i 사용 불가능 : 다른지역(main스레드)의 변수 호출 불가능
                    //2. 현재 코드를 실행하는 스레드 객체의 이름
                    System.out.println("2 thread.getName() : " + thread.getName());
                }
            };
            //*1. 작업스레드 진행
            threadA.start();
        }//for end
        //*2. 작업스레드 실행
        System.out.println("4 thread.getName() : "+thread.getName());

        //p.603 주어진 시간동안 스레드 일시정지  .sleep(밀리초) : 정적메소드(sratic) : 정적메소드 호출하는 방법 : 클래스명.정적메소드();
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        for(int i=0; i<10; i++){
            toolkit.beep();
            System.out.println(" beep ");
            //3초동안 현재 스레드 일시정지
            try{
                Thread.sleep(3000); //3초
            }
            catch (Exception e){
                System.out.println("e = " + e);
            }
        }

        //main 함수 코드 모두 끝나도 작업스레드의 코드가 끝날때까지 대기

    }
}
