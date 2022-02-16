package com.doughdesgin.doughmanagement.services;

import org.springframework.stereotype.Service;

@Service
public class DoughDevServiceImpl implements DoughDevService {
    @Override
    public String findBlog() {
        return "Blog post returned";
    }
}
