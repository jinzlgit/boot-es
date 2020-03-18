package com.es.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.es.boot.entity.mysql.MysqlBlog;

import java.util.List;

/**
 * @author jzl
 * @date 2020/3/18 15:05
 */
public interface MysqlBlogService extends IService<MysqlBlog> {

    List<MysqlBlog> getBlogs(String keywords);

}
