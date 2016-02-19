package com.netease.course.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eric on 2/19/16.
 */

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping(value = "/spring")
    public void spring(HttpServletResponse response) throws IOException {

        response.getWriter().write("Hello, Spring Web!!");
    }
}
