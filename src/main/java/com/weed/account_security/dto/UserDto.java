package com.weed.account_security.dto;

import com.weed.account_security.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String password;
    private String authority;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(this.id)
                .userPassword(this.password)
                .authority(this.authority)
                .build();
    }
}
