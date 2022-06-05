package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링이 뜰 때 controller 객체 생성해서 들고 있음 -> 컴포넌트 스캔 방
public class MemberController {

    private final MemberService memberService;

    @Autowired //DI 의존성 주입
    public MemberController(MemberService memberService) {
        // ->> 생성자 주입 방식 (필드 주입하는 방법도 있는데 안좋은 방법, setter 주입 방식은 public 노출의 위험이 있음)
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

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
