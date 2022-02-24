package com.doughdesgin.doughmanagement.repositories;

import com.doughdesgin.doughmanagement.repositories.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresBlogPostRepository implements BlogPostRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public BlogPost findById(int id) {
        String sql = "SELECT * FROM doughdev.blog_post WHERE id = ?";

        BlogPost result = template.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new BlogPost(
                        rs.getInt("id"),
                        rs.getString("post"),
                        rs.getTimestamp("created_date"),
                        rs.getTimestamp("last_modified_date")
                ));

        return result;
    }
}
