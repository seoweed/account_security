package com.weed.account_security.service;

import com.weed.account_security.crypt.SeedCBC;
import com.weed.account_security.dto.AccountInfoDto;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
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
    public List<AccountInfoEntity> read(String username) {
        SeedCBC seedCBC = new SeedCBC();
        List<AccountInfoEntity> allByUsername = accountInfoRepository.findAllByUsername(username);
        for (AccountInfoEntity accountEntity : allByUsername) {
            accountEntity.setAccountPassword(seedCBC.decoding(accountEntity.getAccountPassword()));
        }
        return allByUsername;
    }
    
    // page read
    public Page<AccountInfoEntity> pageRead(String username, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return accountInfoRepository.findAll(pageable);
    } 

//     계정 정보 수정
    public void save(AccountInfoDto accountInfoDto, Long id) {
        SeedCBC seedCBC = new SeedCBC();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();


            AccountInfoEntity build = AccountInfoEntity.builder()
                    .id(id)
                    .accountId(accountInfoDto.getAccountId())
                    .accountPassword(seedCBC.encoding(accountInfoDto.getAccountPassword()))
                    .site(accountInfoDto.getSite())
                    .saveAt(LocalDateTime.now())
                    .username(username)
                    .build();
            accountInfoRepository.save(build);
        }
    }

//     계정 정보 삭제
    public void delete(Long id) {
        accountInfoRepository.deleteById(id);
    }
}
