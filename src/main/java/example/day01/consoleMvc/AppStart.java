package example.day01.consoleMvc;

public class AppStart {
    public static void main(String[] args) {
        MainView mainView=new MainView();
        mainView.home();

        //2.
        //new MainView().home;

        //3.
        //MainView.getInstance().home();

        //4.
        //MainView.home();

        //5. IOC 제어역전(힙의 제어를 spring이 알아서 해줌)
            //DI 의존성주입
    }
}//c end
