package com.joinpractice.member.dto;

import lombok.Data;

@Data
public class MemberDto {
    private int id;
    private String email;
    private String password;

    public void setSignService(MemberDto memberDto) {
        this.email = memberDto.getEmail();
        this.password = memberDto.getPassword();
    }
}
