package com.weed.account_security.service;

import com.weed.account_security.crypt.SeedCBC;
import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountInfoService {
    private final AccountInfoRepository accountInfoRepository;


    public void save(AccountInfoDto accountInfoDto) {
        SeedCBC seedCBC = new SeedCBC();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();

            AccountInfoEntity build = AccountInfoEntity.builder()
                    .accountId(accountInfoDto.getAccountId())
                    .accountPassword(seedCBC.encoding(accountInfoDto.getAccountPassword()))
                    .site(accountInfoDto.getSite())
                    .saveAt(LocalDateTime.now())
                    .username(username)
                    .build();
            accountInfoRepository.save(build);
        }
    }

//     계정 정보 조회
    // TODO 지금은 사용자의 이름을 파라미터로 받아서 출력해주는데 이렇게 되면 다른 사용자들이 자신 이외의 정보를 볼 수 있음
    // 따라서 로그인 되어있는 사용자의 이름을 자동으로 파라미터에 넣거나 자동으로 들어가게 만들어서 조회를 하면 될것같음
    public List<AccountInfoEntity> read(String username) {
        SeedCBC seedCBC = new SeedCBC();
        List<AccountInfoEntity> allByUsername = accountInfoRepository.findAllByUsername(username);
        for (AccountInfoEntity accountEntity : allByUsername) {
            accountEntity.setAccountPassword(seedCBC.decoding(accountEntity.getAccountPassword()));
        }
        return allByUsername;
    }

//     계정 정보 수정
//    public void update(AccountInfoEntity updateAccountInfoEntity) {
//        SeedCBC seedCBC = new SeedCBC();
//        updateAccountInfoEntity.setAccountPassword(seedCBC.encoding(updateAccountInfoEntity.getAccountPassword()));
//        accountInfoRepository.save(updateAccountInfoEntity);
//    }
//
//     계정 정보 삭제
    public void delete(Long id) {
        accountInfoRepository.deleteById(id);
    }
}
