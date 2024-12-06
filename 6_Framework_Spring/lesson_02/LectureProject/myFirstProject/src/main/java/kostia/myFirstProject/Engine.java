package kostia.myFirstProject;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public Engine() {
        System.out.println("Engine started");
    }

    public void go() {
        System.out.println("Поехали!");
    }
}
