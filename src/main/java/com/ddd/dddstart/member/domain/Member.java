package com.ddd.dddstart.member.domain;

import com.ddd.dddstart.common.model.EmailConverter;
import com.ddd.dddstart.common.model.EmailSet;

import javax.persistence.Column;
import javax.persistence.Convert;

public class Member {

    private Password password;

    @Column(name = "emails")
    @Convert(converter = EmailConverter.class)
    private EmailSet emailSet;

    public void changePassword(String currentPassword, String newPassword)
    {
        if (!currentPassword.matches(newPassword))
        {
            throw new IllegalArgumentException("패스워드 불일치!");
        }

        this.password = new Password(newPassword);
    }
}
