package com.example.project.common.security.custom;

import com.application.user.repository.User;
import lombok.ToString;
import org.springframework.security.core.authority.AuthorityUtils;

@ToString
public class SecurityUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public SecurityUser(User user) {
        super(user.getUserId(), user.getEncryptedPwd(),
                AuthorityUtils.createAuthorityList("USER"));
        this.user = user;
    }

    public User getUser() {
        return user;
    }


}
