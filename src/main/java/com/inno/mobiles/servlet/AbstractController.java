package com.inno.mobiles.servlet;

import com.inno.mobiles.service.MobileService;
import com.inno.mobiles.service.ServiceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class AbstractController extends HttpServlet {
    private MobileService mobileService;
    @Override
    public final void init() throws ServletException {
        mobileService = ServiceManager.getInstance(getServletContext()).getMobileService();

    }

    public final MobileService getMobileService() {
        return mobileService;
    }

}
