package com.weed.account_security.service;

import com.weed.account_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler {
    private final UserRepository userRepository;
}
