package com.dailycodework.buynowdotcom.utils;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CookieUtils {

    @Value("${app.useSecureCookie}")
    private boolean useSecureCookie;

    public void addRefreshTokenCookie(HttpServletResponse response, String refreshToken, long maxAge) {
        if (response == null) {
            throw new IllegalArgumentException("HttpServletResponse cannot be null");
        }

        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true);
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setMaxAge((int) (maxAge / 1000));
        refreshTokenCookie.setSecure(useSecureCookie);
        String sameSite = useSecureCookie ? "None" : "Lax";
        setResponseHeader(response, refreshTokenCookie, sameSite);
    }

    public String getRefreshTokenFromCooies(HttpServletRequest request) {
        Cookie[] clCookies = request.getCookies();
        if (clCookies != null) {
            for (Cookie cookie : clCookies) {
                System.out.println("Names of the cookie found: " + cookie.getName());
                if ("refreshToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public void logCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println("Cookies: " + (cookies != null ? Arrays.toString(cookies) : "null"));
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("Cookie name: " + cookie.getName() + ", value: " + cookie.getValue());
            }
        }
    }

    private void setResponseHeader(HttpServletResponse response, Cookie refreshTokenCookie, String sameSite) {
        StringBuilder cookieHeader = new StringBuilder()
                .append(refreshTokenCookie.getName()).append("=")
                .append(refreshTokenCookie.getValue())
                .append("; HttpOnly; Path=").append(refreshTokenCookie.getPath())
                .append("; Max-Age=").append(refreshTokenCookie.getMaxAge())
                .append(useSecureCookie ? "; Secure" : "")
                .append("; SameSite=").append(sameSite);
        response.setHeader("Set-Cookie", cookieHeader.toString());
    }

}
