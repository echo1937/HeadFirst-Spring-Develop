package com.netease.exam.controller;

import com.netease.exam.dao.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/test")
public class PostBlog {

    @Autowired
    private BlogDAO blogDAO;

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    @RequestMapping("/postblog")
    public void doPostBlog(@RequestParam("blogTitle") String blogTitle,
                           @RequestParam("blogContent") String blogContent,
                           HttpServletResponse response) throws Exception {
        PrintWriter writer = response.getWriter();

        if (blogTitle.length() > 20 || blogContent.length() > 100) {
            System.out.println(blogTitle.length() + ": " + blogContent.length());
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

        } else {

            blogDAO.insertBlog(blogTitle, blogContent);
            response.setStatus(HttpServletResponse.SC_OK);
            writer.write("blogTitle: " + blogTitle);
            writer.write("\nblogContent: " + blogContent);
            writer.write("\nHTTP Status 200");
        }

    }
}
