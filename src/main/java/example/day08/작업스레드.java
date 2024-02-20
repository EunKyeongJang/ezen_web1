package example.day08;

import javax.tools.Tool;
import java.awt.*;

public class 작업스레드 implements Runnable{
        //여러개의 인터페이스를 구현 가능

    //작업스레드가 최초실행하는 함수
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
