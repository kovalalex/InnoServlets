package com.inno.mobiles.servlet;

import com.inno.mobiles.pojo.Mobile;
import com.inno.mobiles.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditMobileController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mobileId = req.getParameter("id");
        if (mobileId == null) {
            throw new ServletException("Missing mobile id");
        }
        req.setAttribute("pageName", "Редактировать мобильный телефон");
        Mobile mobileToEdit = getMobileService().getMobileById(Integer.parseInt(mobileId));
        req.setAttribute("mobile", mobileToEdit);
        RoutingUtils.forwardToPage("edit.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        int price = Integer.parseInt(req.getParameter("price"));
        String manufacturer = req.getParameter("manufacturer");
        Mobile mobile = new Mobile(id, model, price, manufacturer);
        getMobileService().updateMobileByID(mobile);
        RoutingUtils.redirect(req.getContextPath(), req, resp);
    }
}
