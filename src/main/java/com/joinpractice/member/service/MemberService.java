package com.joinpractice.member.service;

import com.joinpractice.member.dto.MemberDao;
import com.joinpractice.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    public void insertMember(MemberDto memberDto) {
        memberDao.insertMember(memberDto);
    }
}
