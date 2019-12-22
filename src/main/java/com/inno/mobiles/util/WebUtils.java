package com.inno.mobiles.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public final class WebUtils {
    public static Cookie findCookie(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName)) {
                    if (c.getValue() != null && !"".equals(c.getValue())) {
                        return c;
                    }
                }
            }
        }
        return null;
    }
}
