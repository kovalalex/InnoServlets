package com.inno.mobiles.service;

import com.inno.mobiles.pojo.Mobile;

import java.util.List;

public interface MobileService {
    public Mobile getMobileById(int id);

    public List<Mobile> listAllProducts();

    public void updateMobileByID(Mobile mobile);

    public void addMobile(Mobile mobile);
}
