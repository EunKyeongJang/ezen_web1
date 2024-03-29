package example.day01.webMvc;
//데이터 접근객체 : db에 접근과 sql(비즈니스 로직) 역할

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDao {
    //1. 필드
    private Connection conn;        //DB연동 인터페이스
    private PreparedStatement ps;   //SQL실행, 매개변수 인터페이스
    private ResultSet rs;           //SQL 실행결과를 호출하는 인터페이스

    //2. 생성자 : db연동코드
    public TodoDao(){
        try {
            //1. jdbc라이브러리 호출
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 연동
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/springweb",
                    "root",
                    "1234");
            System.out.println("DB connect success");
        }
        catch (Exception e){
            System.out.println("DB connect fail : "+e);
        }
    }//생성자 end

    //3. 메소드

    //2. 할일 등록 함수
    public boolean doPost(TodoDto todoDto){
        try{
            //1. SQL 작성
            String sql="insert into todo(content, deadline) values(?,?)";
            //2. SQL 기재
            ps=conn.prepareStatement(sql);
            //3. SQL 매개변수 정의
            ps.setString(1, todoDto.getContent());
            ps.setString(2, todoDto.getDeadline());
            //4. SQL 실행
            int count=ps.executeUpdate();
            //5. SQL 실행결과
            if(count==1){
                return true;
            }
            //6. 함수 리턴
        }
        catch (Exception e){
            System.out.println(e);
        }
        return false;
    }//m end

    //3. 할일 목록 출력 함수
    public ArrayList<TodoDto> doGet(){
        //0. 반환할 todoDto 객체
        ArrayList<TodoDto> list=new ArrayList<>();
        //레코드1개 == TodoDto 1개
        //레코드 여러개 ==
        try{
            //1. SQL 작성
            String sql="select*from todo";
            //2. SQL 기재
            ps=conn.prepareStatement(sql);
            //3. SQL 매개변수 정의
            //4. SQL 실행
            rs=ps.executeQuery();
            //5. SQL 실행결과
            while(rs.next()){   //next() 레코드 이동
                //레코드 1개당 --> dto 1개
                TodoDto todoDto=new TodoDto(
                        rs.getInt("id"),
                        rs.getString("content"),
                        rs.getString("deadline"),
                        rs.getBoolean("state")
                );
                //while문 끝나면 dto 사라져, while 밖에 있는 객체로 이동
                list.add(todoDto);
            }
            //6. 함수 리턴
        }
        catch (Exception e){
            System.out.println(e);
        }
        return list;    //리스트 반환
    }//m end
}//c end
