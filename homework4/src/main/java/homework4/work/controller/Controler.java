package homework4.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controler {

    @GetMapping("/hello")
    public String getHello(Model model){
        model.addAttribute("hello","heloe");
        return "hello";
    }

}
