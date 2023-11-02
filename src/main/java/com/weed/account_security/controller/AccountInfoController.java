package com.weed.account_security.controller;

import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import com.weed.account_security.service.AccountInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountInfoController {
    private final AccountInfoService accountInfoService;
    private final AccountInfoRepository accountInfoRepository;


    // 삭제 예정
    @GetMapping("/user/account/save")
    public String accountSave() {
        return "requestForm";
    }
    // 삭제 예정
    @GetMapping("/user/account/save2")
    public String accountSave2(Model model) {
        model.addAttribute("accountInfoDto", new AccountInfoDto());
        return "accountSaveForm";
    }
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

    // 사용자 정보 list 로 출력
    @GetMapping("/user/accountInfoList")
    public String getAccountInfoList(Model model, @RequestParam("username") String username) {
        List<AccountInfoEntity> accountInfoList = accountInfoService.read(username);
        model.addAttribute("accountInfoList", accountInfoList);
        return "accountInfoList";
    }
    // 계정 정보 삭제
//    @GetMapping("/user/account/delete")
//    public String accountDelete(@RequestParam("id") Long id, @RequestBody String username) {
//        return accountInfoRepository.findUsernameById(id);
////        accountInfoService.delete(id);
//
////        return "redirect://accountInfoList?username=" + username;
//    }


//    @PostMapping("/user/api/submit")
//    public String accountSave(AccountInfoEntity accountInfoEntity, Model model) {
//        model.addAttribute("accountInfoEntity", accountInfoEntity);
//
//
//        accountInfoService.save(accountInfoEntity);
//        return "requestForm";
//    }
}
