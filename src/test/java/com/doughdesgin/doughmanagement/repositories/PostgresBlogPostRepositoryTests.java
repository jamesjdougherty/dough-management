package com.doughdesgin.doughmanagement.repositories;

import com.doughdesgin.doughmanagement.repositories.models.BlogPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PostgresBlogPostRepositoryTests {

    // TODO: Add mockito to test data layer

    @Disabled
    @Test
    void returns_blog_post_from_postgres() {
        PostgresBlogPostRepository repo = new PostgresBlogPostRepository();

        BlogPost response = repo.findById(1);

        Assertions.assertEquals("Something", response.getPost());
    }
}
