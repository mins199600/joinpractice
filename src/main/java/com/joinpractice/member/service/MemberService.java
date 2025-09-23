package com.joinpractice.member.service;

import com.joinpractice.member.dto.MemberDto;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    public void signService(MemberDto memberDto) {
        memberDto.setSignService(memberDto);
    }
}
