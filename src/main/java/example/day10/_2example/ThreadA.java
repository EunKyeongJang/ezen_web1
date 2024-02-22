package example.day10._2example;

public class ThreadA extends Thread{
    private WorkObject workObject;
    public ThreadA(WorkObject workObject){
        setName("ThreadA");
        this.workObject=workObject;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            //현재 메소드 콘솔 출력
            workObject.methodA();
        }
    }
}
