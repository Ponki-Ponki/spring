package homework4.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {

    @RequestMapping("/hello")
    public String getHello(Model model){
        model.addAttribute("hello","heloe");
        return "hello";
    }

}
