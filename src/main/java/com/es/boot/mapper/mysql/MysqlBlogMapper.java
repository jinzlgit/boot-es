package com.es.boot.mapper.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.es.boot.entity.mysql.MysqlBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jzl
 * @date 2020/3/18 14:58
 */
public interface MysqlBlogMapper extends BaseMapper<MysqlBlog> {

    List<MysqlBlog> queryBlogs(@Param("keywords") String keywords);

}
