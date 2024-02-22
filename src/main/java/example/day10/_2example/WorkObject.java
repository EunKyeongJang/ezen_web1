package example.day10._2example;

public class WorkObject {
    
    //1. 함수1
    public synchronized void methodA(){
        //1. 현재 스래드 객체 호출   : Thread.currentThread()
        //2. 스레드의 이름 호출     : .getName()
        Thread thread= Thread.currentThread();
        System.out.println(thread.getName());

        notify();   //다른 스레드를 실행 대기상태로
        try {
            wait();     //현재 스레드를 일시정지 상태로
        }
        catch (InterruptedException e){}
    }
    /*
    //2. 함수2
    public synchronized void methodB(){
        Thread thread= Thread.currentThread();
        System.out.println(thread.getName());

        notify();   //다른 스레드를 실행 대기상태로
        try {
            wait();     //현재 스레드를 일시정지 상태로
        }
        catch (InterruptedException e){}
    }*/
}//c end
/*
    스레드란
    멀티스레드란
    동기화 / 비동기화
    스레드 상태 : 실행대기, 실행, 일시정지
 */
