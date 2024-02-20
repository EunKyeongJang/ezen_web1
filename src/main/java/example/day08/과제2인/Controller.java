package example.day08.과제2인;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    Dao dao;

    @PostMapping("/item/input")
    @ResponseBody
    public Boolean input(Dto dto){


        return dao.input(dto);
    }//m end

    @GetMapping("/item")
    public String pageView(Model model){
        System.out.println("Controller.pageView");
        ArrayList<Dto> list = dao.pageView();
        model.addAttribute("item",list);


        return "/item/index";
    }

    @PostMapping("/item/delete")
    @ResponseBody
    public boolean itemDelete(Dto dto){
        return dao.itemDelete(dto);
    };

    @PostMapping("/item/itemUpdate")
    @ResponseBody
    public boolean itemUpdate(Dto dto){

        return dao.itemUpdate(dto);
    }

}//c end
