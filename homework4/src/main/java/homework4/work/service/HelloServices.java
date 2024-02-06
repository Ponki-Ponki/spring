package homework4.work.service;



import homework4.work.users.Human;
import org.springframework.stereotype.Service;

@Service
public class HelloServices {
    String str;
    public HelloServices() {
        this.str = "Hello ";
    }

    public String hello(){
        return str;
    }
    public void addText(Human user){
        str = "Hello ";
        str = str + user.toString();
    }
}
