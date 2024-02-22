package example.day10._3인servlet실습;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/team4/test")
public class SetvletTest extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("SetvletTest.init");
        super.init(config);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("SetvletTest.service");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SetvletTest.doGet");
        resp.setContentType("text/html");
        resp.getWriter().println("get메소드 실행");
        System.out.println("resp : "+resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SetvletTest.doPost");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SetvletTest.doPut");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SetvletTest.doDelete");
    }

    @Override
    public void destroy() {
        System.out.println("SetvletTest.destroy");
        super.destroy();
    }
}
