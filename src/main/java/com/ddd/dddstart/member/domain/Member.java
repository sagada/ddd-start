package com.ddd.dddstart.member.domain;

public class Member {

    private Password password;

    public void changePassword(String currentPassword, String newPassword)
    {
        if (!currentPassword.matches(newPassword))
        {
            throw new IllegalArgumentException("패스워드 불일치!");
        }

        this.password = new Password(newPassword);
    }
}
