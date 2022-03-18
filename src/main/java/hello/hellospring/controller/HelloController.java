package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "value 간다잉");
        return "hello"; // resources.templates 에 있는 hello.html로 가라는 의미 (ViewResolver가 처리해준다)
    }

}
