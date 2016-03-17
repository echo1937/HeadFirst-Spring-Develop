package com.netease.course.web.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@Controller
public class HelloController {

    //http://localhost:8080/api/hello/users/123?msg=Hello

    @RequestMapping("/users/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        ModelMap map) throws IOException {
        map.addAttribute("name", name);
        map.addAttribute("password", password);
        return "user";
    }


    @RequestMapping("/users/{path:.+}")
    public void list(@PathVariable("path") String path,
                     @RequestHeader("Accept") String accept,
                     HttpServletResponse response) throws Exception {
        System.out.println(path);
        System.out.println(accept);
        boolean isJson = accept.contains("application/json");
        boolean isText = accept.contains("application/xml");

        PrintWriter writer = response.getWriter();
        if (path.endsWith("json") || isJson) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            writer.write("{\"userList\":[{\"userId\": 1001,\"userName\":\"test1\"}," +
                    "{\"userId\": 1002,\"userName\": \"test2\"}]}");

        } else {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
            String file = "/Users/Eric/Documents/IdeaProjects/HeadFirst-Spring-Develop/webhomework/src/main/resources";
            cfg.setDirectoryForTemplateLoading(new File(file));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template ftl = cfg.getTemplate("list.ftl");

            Map<String, Object> root = new HashMap<String, Object>();
            root.put("userId1", "1001");
            root.put("userName1", "test1");
            root.put("userId2", "1002");
            root.put("userName2", "test2");
            ftl.process(root, writer);
        }
    }
}
