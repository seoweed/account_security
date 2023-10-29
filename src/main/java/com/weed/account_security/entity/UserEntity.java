package com.weed.account_security.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "authority", nullable = false)
    private String authority;

    // todo 매핑이 잘 되었는지 확인 and AccountService 의 save 로직 변경 해야할 수도 있음
//    @OneToMany(mappedBy = "user")
//    private List<AccountInfoEntity> accountInfoList = new ArrayList<>();

    @Builder
    public UserEntity(String userId, String userPassword, String authority) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.authority = authority;
    }
}

