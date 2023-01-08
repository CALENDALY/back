package com.example.project.common.security.custom;

import com.example.project.common.error.ErrorCode;
import com.example.project.user.repository.domain.User;
import com.example.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecurityUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optional = userRepository.findByUserId(Long.valueOf(username));
        if(!optional.isPresent()) {
            throw new AuthenticationServiceException(ErrorCode.NOT_EXIST_USER.toString());
        } else {
            User user = optional.get();
            return new SecurityUser(user);
        }

    }
}
