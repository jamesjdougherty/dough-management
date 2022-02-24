package com.doughdesgin.doughmanagement.repositories;

import com.doughdesgin.doughmanagement.repositories.models.BlogPost;

public interface BlogPostRepository {
    BlogPost findById(int id);
}
