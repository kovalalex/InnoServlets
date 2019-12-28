package com.inno.mobiles.servlet;

import com.inno.mobiles.pojo.User;
import com.inno.mobiles.util.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        User user = getUserService().getUserByNamePassword(inputName, inputPassword);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("IS_AUTHENTIFICATED", true);
            String redirectTo = session.getAttribute("REDIRECT_URL_AFTER_SIGNIN").toString();
            if (redirectTo == null) redirectTo = req.getContextPath();
            RoutingUtils.redirect(redirectTo, req, resp);
        } else {
              LOGGER.error("bad sign-in");
            RoutingUtils.redirect(req.getContextPath() + "/sign-in", req, resp);
        }
    }
}
