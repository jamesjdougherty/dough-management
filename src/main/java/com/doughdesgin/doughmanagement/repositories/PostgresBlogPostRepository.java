package com.doughdesgin.doughmanagement.repositories;

import com.doughdesgin.doughmanagement.repositories.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Repository
public class PostgresBlogPostRepository implements BlogPostRepository {

    @Autowired
    JdbcTemplate template;

    @Override
    public BlogPost findById(int id) {
        String sql = "SELECT * FROM doughdev.blog_post WHERE id = ?";

        return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new BlogPost(
                        rs.getInt("id"),
                        rs.getString("post"),
                        rs.getTimestamp("created_date"),
                        rs.getTimestamp("last_modified_date")
                ));
    }

    @Override
    public int saveBlog(String blog) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String insertSql = String.format("insert into doughdev.blog_post(id, post, created_date, last_modified_date) " +
                "values(nextval('dough_blog_id_seq'), '%s', '%s', '%s')", blog, timestamp, timestamp);

        template.update(insertSql);

        String querySql = "SELECT max(id) FROM doughdev.blog_post";

        return template.queryForObject(querySql, new Object[]{}, Integer.class);
    }
}
