package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Controller -> 외부요청 받기
@Controller // @Component 어노테이션이 선언되어 있음 -> @Component를 포함하는 어노테이션은 스프링 빈으로 자동 등록
public class MemberController {
    private final MemberService memberService;

    @Autowired // Controller와 MemberService를 이어준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // get 방식은 보통 url이라고 생각하면 됨,, 조회
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // post 방식은 form에 넣어서 데이터를 전달할 때 사용,, 전달
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
