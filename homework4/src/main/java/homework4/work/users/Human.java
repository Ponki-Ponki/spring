package homework4.work.users;

public class Human {
    String name;
    String pass;

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return
                name +
                ",your password=' " + pass + " ";
    }
}

