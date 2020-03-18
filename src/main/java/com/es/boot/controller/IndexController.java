package com.es.boot.controller;

import com.es.boot.entity.mysql.MysqlBlog;
import com.es.boot.service.MysqlBlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jzl
 * @date 2020/3/18 16:24
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    private MysqlBlogService mysqlBlogService;

    @RequestMapping("/")
    public String index(){
        List<MysqlBlog> mysqlBlogs = mysqlBlogService.list();
        log.info(String.valueOf(mysqlBlogs.size()));
        return "index.html";
    }

}
