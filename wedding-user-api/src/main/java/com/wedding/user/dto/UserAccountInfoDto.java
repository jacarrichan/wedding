package com.wedding.user.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UserAccountInfoDto implements Serializable{

    private static final long serialVersionUID = 5689236568372953969L;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String passwd;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String bridegroomName;

    @Getter
    @Setter
    private Date bridegroomBirthday;

    @Getter
    @Setter
    private String brideName;

    @Getter
    @Setter
    private Date brideBirthday;

}
