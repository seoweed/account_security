package com.weed.account_security.controller;

import com.weed.account_security.dto.UserDto;
import com.weed.account_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/user")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

}
