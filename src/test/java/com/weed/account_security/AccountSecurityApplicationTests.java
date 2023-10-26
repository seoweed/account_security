package com.weed.account_security;

import com.weed.account_security.crypt.SeedCBC;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.repository.AccountInfoRepository;
import com.weed.account_security.service.AccountInfoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Id;
import java.time.LocalDateTime;

@SpringBootTest
class AccountSecurityApplicationTests {
	@Autowired
	private AccountInfoService accountInfoService;
	@Autowired private AccountInfoRepository accountInfoRepository;

	@Test
	void AccountSave() {
		AccountInfoEntity entity = new AccountInfoEntity(1L, "weed", "qe12", "123", LocalDateTime.now());
		accountInfoService.save(entity);

		AccountInfoEntity accountInfoEntity = accountInfoRepository.findById(1L).get();
		System.out.println("accountInfoEntity = " + accountInfoEntity);
		Assertions.assertThat("weed").isEqualTo(accountInfoEntity.getAccountId());
	}

	@Test
	void AccountRead() {
		AccountInfoEntity entity = new AccountInfoEntity(1L, "weed", "qe12", "naver.com", LocalDateTime.now());
		accountInfoService.save(entity);

		AccountInfoEntity read = accountInfoService.read(1L);
		Assertions.assertThat("weed").isEqualTo(accountInfoRepository.findById(1L).get().getAccountId());
		Assertions.assertThat(read.getAccountPassword()).isEqualTo("qe12");
	}

	@Test
	void AccountUpdate() {
		AccountInfoEntity entity1 = new AccountInfoEntity(1L, "weed1", "pass11", "naver.com", LocalDateTime.now());
		AccountInfoEntity entity2 = new AccountInfoEntity(2L, "weed2", "pass22", "google.com", LocalDateTime.now());
		accountInfoService.save(entity1);
		accountInfoService.save(entity2);

		AccountInfoEntity updateEntity = new AccountInfoEntity(1L, "updateWeed", "pass11", "naver.com", LocalDateTime.now());

		accountInfoService.update(updateEntity);


	}

	@Test
	void AccountDelete() {
		AccountInfoEntity entity1 = new AccountInfoEntity(1L, "weed1", "pass11", "naver.com", LocalDateTime.now());
		AccountInfoEntity entity2 = new AccountInfoEntity(2L, "weed2", "pass22", "google.com", LocalDateTime.now());
		accountInfoService.save(entity1);
		accountInfoService.save(entity2);

		accountInfoService.delete(1L);

		Assertions.assertThat(accountInfoRepository.findById(1L)).isEmpty();

	}

}
