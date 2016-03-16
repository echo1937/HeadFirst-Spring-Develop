package com.netease.course.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;


@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/spring")
    public void spring(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello, Spring Web!!");
    }

    //http://localhost:8080/api/hello/users/123?msg=Hello
    @RequestMapping("/users/{userId}")
    public void writer(@PathVariable("userId") String userId,
                       @RequestParam("msg") String msg,
                       @RequestHeader("host") String host,
                       Writer writer) throws IOException {
        writer.write("Hello, here use Writer\n");
        writer.write("userId=" + userId + ", msg=" + msg + ", hostHeader=" + host);
    }

    @RequestMapping("/users/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        ModelMap map) throws IOException {
        map.addAttribute("name", name);
        map.addAttribute("password", password);
        return "user";
    }
}
