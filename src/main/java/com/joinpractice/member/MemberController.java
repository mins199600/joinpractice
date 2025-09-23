package com.joinpractice.member;


import com.joinpractice.member.dto.MemberDto;
import com.joinpractice.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }
    //회원가입 페이지로 클릭 시 이동
    @GetMapping("/join")
    public String join() {
        return "/join";
    }

    //회원가입
    @PostMapping("/join")
    public String signUp(@RequestParam("email") String email, @RequestParam("password") String password) {
        MemberDto memberDto = new MemberDto();
        memberDto.setEmail(email);
        memberDto.setPassword(password);

        memberService.signService(memberDto);
        return "redirect:/index";
    }

}
