package com.inno.mobiles.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Mobile {
    private Integer id;
    private String model;
    private Integer price;
    private String manufacturer;
}

