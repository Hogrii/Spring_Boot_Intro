package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 컨트롤러는 항상 컨트롤러 어노테이션을 달아주어야 한다.
@Controller
public class HelloController {
    // get방식,, index에서 hello 값이 여기로 들어온다.
    @GetMapping("hello")
    public String hello(Model model){
        // data에 hello!!를 담는다.
        model.addAttribute("data", "hello!!");
        // templates에 있는 hello를 찾아서 return 시킨다.
        // 리다이렉트
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}
