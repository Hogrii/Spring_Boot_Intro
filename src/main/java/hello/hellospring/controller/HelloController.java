package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // 정적 컨텐츠
    @GetMapping("hello-string")
    // ResponseBody는 http Body에 직접 내용을 넣어주겠다는 의미
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring", view 이런거 없이 그대로 출력
        // html 태그 이런거 없이 그냥 hello + name 데이터만 그대로 보내버림
    }

    // MVC 방식
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // localhost:8090/hello-api?name=spring!!!!!!!!!
        // {"name":"spring!!!!!!!!!!"} 출력 -> JSON 방식,, key : name, value : spring!!!!!!!!!!
        // JSON 숙지
    }

    static class Hello {
        private String name;
        
        // ALT + Insert => getter and setter 한번에 생성
        // property 접근 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
