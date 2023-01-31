package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Controller -> 외부요청 받기
@Controller // @Component 어노테이션이 선언되어 있음 -> @Component를 포함하는 어노테이션은 스프링 빈으로 자동 등록
public class MemberController {
    private final MemberService memberSerivce;

    @Autowired // Controller와 MemberService를 이어준다.
    public MemberController(MemberService memberService) {
        this.memberSerivce = memberService;
    }
}
