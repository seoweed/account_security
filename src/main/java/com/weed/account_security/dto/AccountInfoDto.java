package com.weed.account_security.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.weed.account_security.entity.AccountInfoEntity;
import com.weed.account_security.entity.UserEntity;
import com.weed.account_security.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoDto {

    private String accountId;

    private String accountPassword;

    private String site;


//    private String userId;

//    private LocalDateTime saveAt;

//    public AccountInfoEntity toAccountInfoEntity() {
//
//        return AccountInfoEntity.builder()
//                .accountId(this.accountId)
//                .accountPassword(this.accountPassword)
//                .site(this.site)
////                .user(userService) //  그냥 바로 username으로 받지 말고 entity를 받아오면 안되나요??
////                .saveAt(this.saveAt)
//                .build();
//    }
}
