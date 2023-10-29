package com.weed.account_security.service;

import com.weed.account_security.crypt.SeedCBC;
import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.entity.UserEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import com.weed.account_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountInfoService {
    private final AccountInfoRepository accountInfoRepository;
    private final UserRepository userRepository;

    // 현재 로그인 되어있는 사용자 정보 가져오기
//    public void getLoginInfo() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserDetails userDetails = (UserDetails)principal;
//        String username = ((UserDetails) principal).getUsername();
//        String password = ((UserDetails) principal).getPassword();
//        System.out.println(username);
//        System.out.println(password);
//    }


    // 계정 정보 저장
    public void save(AccountInfoDto accountInfoDto) {

        SeedCBC seedCBC = new SeedCBC();
        String accountPasswordEncoding = seedCBC.encoding(accountInfoDto.getAccountPassword());

//        UserEntity userEntity = userRepository.findById(accountInfoDto.getUserId()).get();

        AccountInfoEntity result = AccountInfoEntity.builder()
                .accountId(accountInfoDto.getAccountId())
                .accountPassword(accountPasswordEncoding)
                .site(accountInfoDto.getSite())
                .saveAt(LocalDateTime.now())
//                .user(userEntity)
                // todo 변경 가능
                .build();

        accountInfoRepository.save(result);
    }
//     계정 정보 조회
    public AccountInfoEntity read(Long id) {
        SeedCBC seedCBC = new SeedCBC();
        AccountInfoEntity accountInfoEntity = accountInfoRepository.findById(id).get();
        String decoding = seedCBC.decoding(accountInfoEntity.getAccountPassword());
        accountInfoEntity.setAccountPassword(decoding);
        return accountInfoEntity;
    }

//     계정 정보 수정
    public void update(AccountInfoEntity updateAccountInfoEntity) {
        SeedCBC seedCBC = new SeedCBC();
        updateAccountInfoEntity.setAccountPassword(seedCBC.encoding(updateAccountInfoEntity.getAccountPassword()));
        accountInfoRepository.save(updateAccountInfoEntity);
    }
//
//     계정 정보 삭제
    public void delete(Long id) {
        accountInfoRepository.deleteById(id);
    }
}
