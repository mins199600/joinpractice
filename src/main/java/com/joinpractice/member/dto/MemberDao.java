package com.joinpractice.member.dto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    // 회원 가입
    void insertMember(MemberDto memberDto);

    // 로그인
    MemberDto findByEmailAndPassword(MemberDto memberDto);
}
