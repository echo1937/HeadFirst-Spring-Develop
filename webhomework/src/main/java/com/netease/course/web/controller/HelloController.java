package com.netease.course.web.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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


    @RequestMapping("/users/list")
    public void list(Writer writer) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(
                new File("/Users/Eric/Documents/IdeaProjects/HeadFirst-Spring-Develop/webhomework/src/main/resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template ftl = cfg.getTemplate("list.ftl");

        Map<String, Object> root = new HashMap<String, Object>();
        root.put("userId1", "1001");
        root.put("userName1", "test1");
        root.put("userId2", "1002");
        root.put("userName2", "test2");

        Writer out = new OutputStreamWriter(System.out);
        ftl.process(root, writer);
    }
}
