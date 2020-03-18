package com.es.boot.controller;

import com.alibaba.fastjson.JSON;
import com.es.boot.entity.es.EsBlog;
import com.es.boot.entity.mysql.MysqlBlog;
import com.es.boot.mapper.es.EsBlogMapper;
import com.es.boot.mapper.mysql.MysqlBlogMapper;
import com.es.boot.service.MysqlBlogService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jzl
 * @date 2020/3/18 14:59
 */
@RestController
@Slf4j
public class DataController {

    @Autowired
    private MysqlBlogService mysqlBlogService;

    @Autowired
    private EsBlogMapper esBlogMapper;

    @GetMapping("/blogs")
    public Object blogs(){
        List<MysqlBlog> blogList = mysqlBlogService.list();
        log.info(JSON.toJSONString(blogList));
        return blogList;
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param){
        Map<String, Object> map = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();
        String type = param.getType();
        if (type.equalsIgnoreCase("mysql")){
            // mysql
            List<MysqlBlog> blogList = mysqlBlogService.getBlogs(param.getKeyword());
            map.put("list", blogList);
        } else if (type.equalsIgnoreCase("es")){
            // es
//            POST /blog/_search
//            {
//                "query": {
//                "bool": {
//                    "should": [
//                    {
//                        "match_phrase": {
//                        "title": "大海"
//                    }
//                    },
//                    {
//                        "match_phrase": {
//                        "content": "大海"
//                    }
//                    }
//      ]
//                }
//            }
//            }
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title", param.getKeyword()));
            builder.should(QueryBuilders.matchPhraseQuery("content", param.getKeyword()));
            String s = builder.toString();
            System.out.println(s);
            Page<EsBlog> search = (Page<EsBlog>) esBlogMapper.search(builder);
            List<EsBlog> content = search.getContent();
            map.put("list", content);
        } else {
            return "i don't understand";
        }
        watch.stop();
        long totalTimeMillis = watch.getTotalTimeMillis();
        map.put("duration", totalTimeMillis);

        return map;
    }

    @Data
    public static class Param{
        // mysql es
        private String type;

        private String keyword;
    }
}
