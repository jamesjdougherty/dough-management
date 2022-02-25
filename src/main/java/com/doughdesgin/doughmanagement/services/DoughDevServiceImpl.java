package com.doughdesgin.doughmanagement.services;

import com.doughdesgin.doughmanagement.repositories.BlogPostRepository;
import com.doughdesgin.doughmanagement.repositories.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoughDevServiceImpl implements DoughDevService {

    @Autowired
    BlogPostRepository blogPostRepository;

    @Override
    public String findBlog() {
        BlogPost blogPost = blogPostRepository.findById(1);

        return blogPost.getPost();
    }

    @Override
    public int saveBlog(String blog) {
        return 0;
    }
}
