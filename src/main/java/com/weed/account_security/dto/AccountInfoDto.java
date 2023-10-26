package com.weed.account_security.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.weed.account_security.entity.AccountInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountInfoDto {

    private Long id;

    private String accountId;

    private String accountPassword;

    private String site;

    private LocalDateTime saveAt;

    public AccountInfoEntity toAccountInfoEntity() {
        return AccountInfoEntity.builder()
                .accountId(this.accountId)
                .accountPassword(this.accountPassword)
                .site(this.site)
//                .saveAt(this.saveAt)
                .build();
    }
}
