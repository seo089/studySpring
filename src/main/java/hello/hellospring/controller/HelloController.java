package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "value 간다잉");
        return "hello"; // resources.templates 에 있는 hello.html로 가라는 의미 (ViewResolver가 처리해준다)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        //model에 get 방식으로 들어온 name param을 담아서 hello-template 페이지로 던진다
        // http://localhost:8080/hello-mvc?name=seoyoung
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http body에다가 return 내용을 직접 넣어 주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // view 없이 그대로 html로 보내준다
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체를 responseBody로 반환하면 기본 set json으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        //http://localhost:8080/hello-api?name=seoyoung >> json 방식으로 html 출력됨
//        {
//            "name": "seoyoung"
//        }
        return hello; 
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
