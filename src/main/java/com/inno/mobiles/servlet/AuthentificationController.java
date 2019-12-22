package com.inno.mobiles.servlet;

import com.inno.mobiles.pojo.User;
import com.inno.mobiles.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sign-in")
public class AuthentificationController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageName", "Авторизация");
        RoutingUtils.forwardToPage("sign-in.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputName = req.getParameter("name");
        String inputPassword = req.getParameter("password");
        System.out.println(inputName + " " + inputPassword);
        User user = getUserService().getUserByNamePassword(inputName, inputPassword);
        System.out.println(user);
        if (user != null) {
            req.getSession().setAttribute("IS_AUTHENTIFICATED", true);
            RoutingUtils.redirect(req.getContextPath(), req, resp);

        } else
            RoutingUtils.redirect(req.getContextPath() + "/sign-in", req, resp);
    }
}
