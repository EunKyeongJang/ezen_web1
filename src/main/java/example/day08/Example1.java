package example.day08;

import javax.tools.Tool;
import java.awt.*;
import java.util.spi.ToolProvider;

public class Example1 {
    /*
        운영체제를 실행중인 프로그램을 프로세스로 관리
            - 프로그램 1개당 프로세스 존재
            - 멀티테스킹 : 두가지 이상을 동시에 처리
                - 프로그램 1개당 멀티프로세스 존재할 수 있다.
                - 프로세스 1개당 멀티 스레드 존재할 수 있다.
            - 멀티 스레드 :  하나의 프로세스가 두가지 이상의 작업을 처리
        스레드 : 코드의 실행 흐름
            - 스레드마다 스택 할당
            - 스레드끼리 자원공유 안됨.
            - 하나의 스레드가 예외 발생 시 전체 스레드가 예외 발생
        멀티스레드 : 여러개의 코드 실행 흐름
            - 생성 : main 스레드가 추가 작업 스레드 생성
            - 자바는 무조건 하나의 스레드르르 갖는다 Main 함수()
        작업요청
            멀티 : 안됨
                ->여러개 스레드들의 작업순서는 하나씩 처리(컴퓨어는 빠르기 때문에 동시처리)
            - 작업순서 : 운영체제가 스케줄링
            - 자바에서 서로다른 스레드끼리의 작업순서 정하기 불가능.
            - 프로그램(소프트웨어)는 자원(하드웨어) 제어권이 없다.(운영체제가 자원 할당 -> 운영체제 스케줄링 알고리즘)
        JVM
        메소드영역           스택영역                    힙영역
        - 클래스정보         - 스레드마다 할당            - 인스턴스 할당
        - static           - 함수 실행{}, 지역변수 할당
     */
    //1. main 스레드(메인함수) 생성
    public static void main(String[] args) {
    //================================== 단일스레드일때 ========================================
        //* Java.awt : java.ui
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=1; i>=5; i++) {   //main 스레드가 for 실행
            toolkit.beep(); //비프음 발생
            //비프음이 한번 발생하는 것보다 for문이 5번 실행되는것이 빠르기 때문에 소리가 한번만 남
            //메인스레드를 잠시 멈추기 : Thread.sleep(??ms);
                //*일반예외처리 : 혹시 일시정시 도중 스레드가 예외를 발생시킬 수 있기 때문에
            try {
                Thread.sleep(500);  //메인스레드를 0.5초간 일시정지
            }
            catch (InterruptedException e){
                System.out.println("e = " + e);
            }
        }//for end

        for(int i=1; i<=5; i++){
            System.out.println("띵1");
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                System.out.println("e = " + e);
            }
        }//for end
    //============================== 단일스레드일때 end =====================================

    //=============================== 멀티스레드일때 ========================================
        //1. Runnable 인터페이스 구현객체 필요
            //1. 구현클래스
            //2. 익명구현   : 인터페이스가 new 이용한 직접 추상메소드 재정의
                //new 인터페이스명({})
        //2. 구현객체를 Thread 생성자에 대입
        Thread thread=new Thread(new Runnable() {
        //=========== 작업스레드 구현 ===========
            @Override
            public void run() { //[작업스레드가 코드 실행] 1. 작업스레드가 실행하는 메소드 정의
                Toolkit toolkit1=Toolkit.getDefaultToolkit();
                for(int i=1; i<=5; i++){
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        System.out.println("e = " + e);
                    }
                }//for end
            }//overriding end
        //========================== 작업스레드 구현 end ========================
        });
        thread.start(); //2. 작업스레드 실행;

        for(int i=1; i<=5; i++){    //main thread가 코드를 처리
            System.out.println("띵2");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                System.out.println("e = " + e);
            }
        }//for end

        //======================== 멀티스레드2 [구현클래스] 일때 ============================
        //여러개의 인터페이스를 구현 가능
        //1. Runnable 객체
        Runnable runnable=new 작업스레드();
        //2. Thread 객체
        Thread thread1=new Thread(runnable);

        thread1.start();

        for(int i=1; i<=5; i++){    //main thread가 코드를 처리
            System.out.println("띵3");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                System.out.println("e = " + e);
            }
        }//for end
        //======================== 멀티스레드2 [구현클래스] 일때 end ============================

        //======================== 멀티스레드2 [Thread 상속] 일때 ============================
        //--- 하나의 부모만 가질 수 있음(확장성 떨어짐) -> 인터페이스(Runnable)로 해결 ---
        //자식객체
        작업스레드2 작업스레드2=new 작업스레드2();
        작업스레드2.start();
        //vs
        //익명 자식객체
        Thread thread2=new Thread() {
            @Override
            public void run() {
                for(int i=1; i<=5; i++){
                    Toolkit toolkit=Toolkit.getDefaultToolkit();
                    toolkit.beep();

                    try{
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        System.out.println("e = " + e);
                    }
                }//for end
            }
        };
        thread2.start();

        //======================== 멀티스레드2 [Thread 상속] 일때 end ============================



    }//m end
}//c end
