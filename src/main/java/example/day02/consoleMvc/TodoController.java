package example.day02.consoleMvc;

import java.util.ArrayList;

public class TodoController {

    private TodoDao todoDao=new TodoDao();

    //2. 할일 등록 함수
    public boolean doPost(TodoDto todoDto){
        return todoDao.doPost(todoDto);
    }//m end

    //3. 할일 목록 출력 함수
    public ArrayList<TodoDto> doGet(){
        return todoDao.doGet();
    }//m end

    //4. 할일 상태 수정 함수
    public boolean doPut(TodoDto todoDto){
        return todoDao.doPut(todoDto);
    }//m end

    //5. 할일 삭제 함수
    public boolean doDelete(int id) {
        return todoDao.doDelete(id);
    }//m end

}//c end
