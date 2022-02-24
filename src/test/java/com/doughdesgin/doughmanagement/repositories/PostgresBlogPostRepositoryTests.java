package com.doughdesgin.doughmanagement.repositories;

import com.doughdesgin.doughmanagement.repositories.models.BlogPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PostgresBlogPostRepositoryTests {

    @MockBean
    PostgresBlogPostRepository repoMock = Mockito.mock(PostgresBlogPostRepository.class);

    @BeforeEach
    void setup() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Mockito.when(repoMock.findById(1))
                .thenReturn(new BlogPost(
                        1,
                        "A test blog post",
                        timestamp,
                        timestamp
                ));
    }

    @Disabled
    @Test
    void returns_blog_post_from_postgres_repo() {
        int id = 12345;

        BlogPost blogPost = repoMock.findById(id);

        Assertions.assertEquals("something", blogPost.getPost());
    }
}
