package com.weed.account_security.controller;

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

    @GetMapping("/account/save")
    public String accountSave() {
        return "requestForm";
    }

    @PostMapping("/api/submit")
    public String accountSave(AccountInfoEntity accountInfoEntity, Model model) {
        model.addAttribute("accountInfoEntity", accountInfoEntity);

        accountInfoService.save(accountInfoEntity);
        return "requestForm";
    }
}
