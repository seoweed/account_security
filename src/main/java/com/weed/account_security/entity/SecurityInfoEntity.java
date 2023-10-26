package com.weed.account_security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "security_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hashed_password")
    private String hashedPassword;
    @Column(name = "sorted_password")
    private String sortedPassword;
}
