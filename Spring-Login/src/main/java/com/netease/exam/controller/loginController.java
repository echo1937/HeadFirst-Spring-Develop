package com.netease.exam.controller;

import com.netease.exam.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping(value = "/hello")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @RequestMapping("/users/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        if (userDAO.selectUser(name).equals(password) && !password.equals("")) {
            session.setAttribute("isLogin", name);
            session.setMaxInactiveInterval(60);
            response.sendRedirect("http://localhost:8080/api/hello/users/user");
        }
        return "failed";
    }

    @RequestMapping("/users/user")
    public String loginSuccess(HttpServletRequest request, ModelMap map) {

        HttpSession session = request.getSession();
        if (session.getAttribute("isLogin") == null) {
            return "failed";
        }

        map.addAttribute("name", (String) session.getAttribute("isLogin"));
        map.addAttribute("password", "******");
        return "user";
    }
}

