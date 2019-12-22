package com.inno.mobiles.servlet;

import com.inno.mobiles.pojo.Mobile;
import com.inno.mobiles.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class AllMobilesController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Mobile> mobiles = getMobileService().listAllProducts();
        req.setAttribute("pageName", "Список мобильных телефонов");
        req.setAttribute("mobiles", mobiles);
        RoutingUtils.forwardToPage("mobile.jsp", req, resp);
    }
}
