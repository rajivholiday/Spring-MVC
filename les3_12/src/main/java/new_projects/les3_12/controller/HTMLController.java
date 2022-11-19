package new_projects.les3_12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLController {

    @RequestMapping("/cat/default")
    String handler1() {
        return "index.html";
    }

    @RequestMapping("/dog/default")
    String handler2() {
        return "index.html";
    }

    @RequestMapping("/parrot/default")
    String handler3() {
        return "index.html";
    }
}
