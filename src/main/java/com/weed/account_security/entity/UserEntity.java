package com.weed.account_security.entity;

import lombok.*;
import javax.persistence.*;

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

    @Builder
    public UserEntity(String userId, String userPassword, String authority) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.authority = authority;
    }
}

