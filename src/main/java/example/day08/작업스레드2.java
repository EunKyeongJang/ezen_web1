package example.day08;

import java.awt.*;

public class 작업스레드2 extends Thread{
        //하나의 부모만 가질 수 있음(확장성 떨어짐) -> 인터페이스(Runnable)로 해결
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
}//c end
