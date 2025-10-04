package com.joinpractice.member;

import com.joinpractice.member.dto.MemberDto;
import com.joinpractice.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String signUp(@ModelAttribute MemberDto memberDto) {
        memberService.insertMember(memberDto);
        return "/success";
    }

    // 로그인 처리 (세션 활용)
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        MemberDto loginMember = memberService.login(memberDto);

        if (loginMember != null) {
            // 로그인 성공 - 세션에 사용자 정보 저장
            session.setAttribute("loginMember", loginMember);
            return "/success";  // success 페이지로 리다이렉트
        } else {
            // 로그인 실패
            return "redirect:/?error=true";
        }
    }

    // 성공 페이지 (세션에서 사용자 정보 가져오기)
    @GetMapping("/success")
    public String success(HttpSession session, Model model) {
        // 세션에서 로그인 정보 가져오기
        MemberDto loginMember = (MemberDto) session.getAttribute("loginMember");

        // 로그인 상태가 아니면 로그인 페이지로 리다이렉트
        if (loginMember == null) {
            return "redirect:/success";
        }
        else {
            // 로그인 실패
            return "redirect:/?error=true";
        }
    }


}
