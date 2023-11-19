package com.weed.account_security.controller;

import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import com.weed.account_security.service.AccountInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountInfoController {
    private final AccountInfoService accountInfoService;
    private final AccountInfoRepository accountInfoRepository;

    // account 저장 Form
    @GetMapping("/user/accountForm")
    public String showAccountForm(Model model) {
        model.addAttribute("accountInfoDto", new AccountInfoDto());
        return "accountSave";
    }

    // account 정보 저장 API
    @PostMapping("/user/submit")
    public String accountDtoSubmit(@ModelAttribute AccountInfoDto accountInfoDto) {
        accountInfoService.save(accountInfoDto);
        return "redirect:/user/accountForm";
    }
//    @GetMapping("/user/updateForm")
//    public String showUpdateForm(Model model) {
//        model.addAttribute("accountInfoDto", new AccountInfoDto());
//        return "accountUpdate";
//    }
//    // account 정보 수정 후 저장
//    @PostMapping("/user/update")
//    public String accountUpdate(@ModelAttribute AccountInfoDto accountInfoDto, @RequestParam("id") Long id) {
//        accountInfoService.save(accountInfoDto, id);
//        return "redirect:/user/accountForm";
//    }

    // 사용자 정보 list 로 출력
    // 현재 로그인 되어있는 사용자의 정보를 가져와서 로그인 한 사용자만 볼 수 있도록 만듬
    @GetMapping("/user/accountInfoList")
    public String getAccountInfoList(Model model, Principal principal) {
        String username = principal.getName();
        List<AccountInfoEntity> accountInfoList = accountInfoService.read(username);
        model.addAttribute("accountInfoList", accountInfoList);
        return "accountInfoList";
    }
    // 계정 정보 삭제
    @GetMapping("/user/account/delete")
    public String accountDelete(@RequestParam("id") Long id) {
        accountInfoService.delete(id);

        return "redirect:/user/accountInfoList";
    }
}
