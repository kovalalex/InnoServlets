package com.inno.mobiles.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
}
