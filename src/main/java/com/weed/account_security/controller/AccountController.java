//package com.weed.account_security.controller;
//
//import com.weed.account_security.dto.AccountInfoDto;
//import com.weed.account_security.entity.AccountInfoEntity;
//import com.weed.account_security.entity.UserEntity;
//import com.weed.account_security.service.AccountInfoService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping
//@RequiredArgsConstructor
//public class AccountController {
//    private final AccountInfoService accountInfoService;
//
//    @PostMapping("/user/account/save2")
//    public void accountSave(@RequestBody AccountInfoDto accountInfoDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User currentUser = (User) authentication.getPrincipal();
//
//
//        String username = currentUser.getUsername();
//        accountInfoDto.setUserId(username);
//
//        accountInfoService.save(accountInfoDto);
//
////        return new ResponseEntity<>("성공적으로 저장되었습니다.", HttpStatus.CREATED);
//    }
//}
//        if (!currentUser.getId().equals(userId)) {
//            // 현재 로그인한 사용자와 조회 대상 사용자가 다를 경우 권한 에러를 반환합니다.
//            return new ResponseEntity<>("권한이 없습니다.", HttpStatus.FORBIDDEN);
//        }