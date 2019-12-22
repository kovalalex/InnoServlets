package com.inno.mobiles.servlet;

import com.inno.mobiles.service.MobileService;
import com.inno.mobiles.service.ServiceManager;
import com.inno.mobiles.service.UserService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {
    private MobileService mobileService;
    private UserService userService;

    @Override
    public final void init() {
        mobileService = ServiceManager.getInstance(getServletContext()).getMobileService();
        userService = ServiceManager.getInstance(getServletContext()).getUserService();

    }

    public final UserService getUserService() {
        return userService;
    }

    public final MobileService getMobileService() {
        return mobileService;
    }

}
