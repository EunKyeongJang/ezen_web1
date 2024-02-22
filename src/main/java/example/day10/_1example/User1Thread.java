package example.day10._1example;


public class User1Thread extends Thread{
    //extends Thread : 작업스레드 생성하기 위해

    //1. 필드, 유저1 객체가 가지고 있는 계산기
    private Calculator calculator;

    public User1Thread(){
        //setName : Thread 클레스로부터 상속받은 함수(작업스레드)
        setName("User1Thread");
    }

    //setter : 외부로부터 계산기를 받아 계산기를 넣어주겠다.
    public void setCalculator(Calculator calculator){
        this.calculator=calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}//c end
