package com.es.boot.entity.mysql;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jzl
 * @date 2020/3/18 14:11
 */
@Data
@TableName("t_blog")
public class MysqlBlog implements Serializable {

    private static final long serialVersionUID = 836275548382339013L;

    @TableId
    private Integer id;

    private String title;

    private String author;

//    @TableField(columnDefinition = "mediumtext")
    private String content;

    private Date createTime;

    private Date updateTime;

}
