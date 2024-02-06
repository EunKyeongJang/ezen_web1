package example.day01.webMvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController //해당 클래스를 스프링 mvc 환경에 등록
public class TodoController {

    private TodoDao todoDao=new TodoDao();

    //2. 할일 등록 함수
    @GetMapping("/todo/post.do")
    public boolean doPost(TodoDto todoDto){
        return todoDao.doPost(todoDto);
    }//m end
    //http://localhost:8000/todo/post.do?content=안녕하세요&deadline=2024-02-05

    //3. 할일 목록 출력 함수
    @GetMapping("/todo/get.do")
    public ArrayList<TodoDto> doGet(){
        return todoDao.doGet();
    }//m end

    //http://localhost:8000/todo/get.do
}//c end
