package com.inno.mobiles.servlet;

import com.inno.mobiles.pojo.Mobile;
import com.inno.mobiles.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-mobile")
public class AddMobileController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("pageName", "Добавить мобильный телефон");

        RoutingUtils.forwardToPage("addMobile.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        String manufacturer = req.getParameter("manufacturer");
        Mobile mobile = new Mobile(null, model, price, manufacturer);
        getMobileService().addMobile(mobile);
        RoutingUtils.redirect(req.getContextPath(), req, resp);
    }
}
