package homework4.work.controller;

import homework4.work.service.HelloServices;
import homework4.work.users.Human;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    private HelloServices serv;

    @RequestMapping("/hello")
    public String getHello(Model model){
        model.addAttribute("hello",serv.hello());
        return "hello";
    }

    @PostMapping("/hello")
    public String helloHuman(Human user, @NotNull Model model){
        serv.addText(user);
        model.addAttribute("hello",serv.hello());
        return "hello";
    }

}
