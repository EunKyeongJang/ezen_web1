package book.dao;

import book.dto.ArticleForm;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.concurrent.ExecutionException;

@Component  //스프링 컨테이너에 해당 클래스를 빈(객체) 등록
public class ArticleDao {
    //====DB연동====
    //1. DB 연동 필요한 인터페이스 (구현객체 => 각 회사(com.mysql.cj.jdbc 패키지 내 Driver클래스) ) 필드 선언
    protected Connection conn;        //DB연동 결과 객체를 연결, SQL / 기재된 SQL Statement 객체 반환
    protected PreparedStatement ps;   //Statement : 기재 / 기재된 SQL 에 매개변수 할당, SQL 실행
    protected ResultSet rs;           //select 결과 여러개 레코드를 호출

    public ArticleDao(){
        try{
            //1. mysql JDBC 호출 단 라이브러리 다운로드 > runtimeOnly 'com.mysql:mysql-connector-j'	//mysql 라이브러리
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 해당 db서버의 주소와 db연동
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/springweb","root","1234");
        }
        catch (Exception e){
            System.out.println("[오류] : "+e);
        }
    }

    //1. 등록
    public boolean createArticle(ArticleForm form){
        System.out.println("ArticleDao.createArticle");
        try{            //0. try{}catch (Exception e){}
            String sql="insert into article(title, content) value(?, ?)";   //1.
            ps=conn.prepareStatement(sql);//2.
            ps.setString(1, form.getTitle());//3.
            ps.setString(2, form.getContent());
            int count=ps.executeUpdate();//4.
            //5.
            if(count==1){
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return false;
    }
}
