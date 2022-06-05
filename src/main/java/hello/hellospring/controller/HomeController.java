package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    //스프링 컨테이너 안에 관련 컨트롤러를 먼저 찾고 static > index.html로 가는거라 먼저 여기서 찾았기 때문에
    //index.html로 가지 않고 home.html로 띄움
    public String home() {
        return "home";
    }
}
