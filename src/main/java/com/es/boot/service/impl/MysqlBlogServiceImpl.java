package com.es.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.es.boot.entity.mysql.MysqlBlog;
import com.es.boot.mapper.mysql.MysqlBlogMapper;
import com.es.boot.service.MysqlBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jzl
 * @date 2020/3/18 15:07
 */
@Service
public class MysqlBlogServiceImpl extends ServiceImpl<MysqlBlogMapper, MysqlBlog> implements MysqlBlogService {

    @Autowired
    private MysqlBlogMapper mysqlBlogMapper;

    @Override
    public List<MysqlBlog> getBlogs(String keywords) {
        return mysqlBlogMapper.queryBlogs(keywords);
    }
}
