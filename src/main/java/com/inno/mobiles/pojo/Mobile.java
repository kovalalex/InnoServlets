package com.inno.mobiles.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Mobile {
    private Integer id;
    private String model;
    private Integer price;
    private String manufacturer;
}

