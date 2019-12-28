package com.inno.mobiles.service;

import com.inno.mobiles.pojo.User;

public interface UserService {
    public User getUserByNamePassword(String name, String password);
}
