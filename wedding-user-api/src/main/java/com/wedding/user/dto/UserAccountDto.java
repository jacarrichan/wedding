package com.wedding.user.dto;

import lombok.Setter;
import lombok.Getter;

/**
 * Created by tank on 14-9-15.
 */
public class UserAccountDto {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userAccount;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Integer type;

    @Getter
    @Setter
    private Integer referId;
}
