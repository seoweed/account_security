package com.weed.account_security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "account_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "account_password")
    private String accountPassword;

    private String site;
    @Column(name = "save_at")
    private LocalDateTime saveAt;

    private String username;
}
