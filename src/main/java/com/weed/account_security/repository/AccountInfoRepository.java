package com.weed.account_security.repository;

import com.weed.account_security.entity.AccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, Long> {
    List<AccountInfoEntity> findAllByUsername(String username);
}
