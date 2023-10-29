package com.weed.account_security.controller;

import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.service.AccountInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccountInfoController {
    private final AccountInfoService accountInfoService;

    @GetMapping("/user/account/save")
    public String accountSave() {
        return "requestForm";
    }

    @GetMapping("/user/account/save2")
    public String accountSave2(Model model) {
        model.addAttribute("accountInfoDto", new AccountInfoDto());
        return "accountSaveForm";
    }

//    @PostMapping("/user/api/submit")
//    public String accountSave(AccountInfoEntity accountInfoEntity, Model model) {
//        model.addAttribute("accountInfoEntity", accountInfoEntity);
//
//
//        accountInfoService.save(accountInfoEntity);
//        return "requestForm";
//    }
}
