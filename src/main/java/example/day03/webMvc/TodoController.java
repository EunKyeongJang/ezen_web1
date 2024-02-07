package example.day03.webMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//스프링이에게 해당 클래스가 컨트롤이라는걸 알려야 한다.
@RestController //스프링부트 시작할 때 스프링 컨테이너에 [스프링이 관리하는 메모리 공간] 빈(객체) 등록 => IOC 기법(Inversion if Dontrol)
                //IOC 제어역전 : 개발자가 객체관리x, 스프링이 대신
public class TodoController {

    @Autowired  //스프링 컨테이너의 빈 찾아서 주입//전제조건 : 빈 등록 되었을때
    private TodoDao todoDao;

    //2. 할일 등록 함수
    @PostMapping("/todo/post.do")
    public boolean doPost(TodoDto todoDto){
        return todoDao.doPost(todoDto);
    }//m end

    //3. 할일 목록 출력 함수
    @GetMapping("/todo/get.do")
    public ArrayList<TodoDto> doGet(){
        return todoDao.doGet();
    }//m end

    //4. 할일 상태 수정 함수
    @PutMapping("/todo/put.do")
    public boolean doPut(TodoDto todoDto){
        return todoDao.doPut(todoDto);
    }//m end

    //5. 할일 삭제 함수
    @DeleteMapping("/todo/delete.do")
    public boolean doDelete(int id) {
        return todoDao.doDelete(id);
    }//m end

}//c end
