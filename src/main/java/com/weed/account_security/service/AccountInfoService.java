package com.weed.account_security.service;

import com.weed.account_security.crypt.SeedCBC;
import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountInfoService {
    private final AccountInfoRepository accountInfoRepository;

    // 계정 정보 저장
    public void save(AccountInfoEntity accountInfoEntity) {

        SeedCBC seedCBC = new SeedCBC();
        String accountPasswordEncoding = seedCBC.encoding(accountInfoEntity.getAccountPassword());

        AccountInfoEntity result = AccountInfoEntity.builder()
                .accountId(accountInfoEntity.getAccountId())
                .accountPassword(accountPasswordEncoding)
                .site(accountInfoEntity.getSite())
                .saveAt(LocalDateTime.now())
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
