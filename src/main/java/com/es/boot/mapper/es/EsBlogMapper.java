package com.es.boot.mapper.es;

import com.es.boot.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author jzl
 * @date 2020/3/18 16:36
 */
public interface EsBlogMapper extends ElasticsearchRepository<EsBlog, Integer> {
}
