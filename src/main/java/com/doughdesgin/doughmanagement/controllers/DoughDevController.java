package com.doughdesgin.doughmanagement.controllers;

import com.doughdesgin.doughmanagement.services.DoughDevService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doughdev")
public class DoughDevController {
    private final Logger logger;
    private final DoughDevService doughDevService;

    @Autowired
    DoughDevController(Logger logger, DoughDevService doughDevService) {
        this.logger = logger;
        this.doughDevService = doughDevService;
    }

    @GetMapping("log")
    public void logMessage() {
        logger.info("Test logger message");
    }

    @CrossOrigin
    @GetMapping("findBlog")
    public String findBlog() {
        return this.doughDevService.findBlog();
    }

    @CrossOrigin
    @PostMapping("saveBlog")
    public int save(@RequestBody String blog) {
        logger.info("Dough Management API received request to save blog post");

        try {
            int blogId = doughDevService.saveBlog(blog);
            logger.info("Successfully saved blog id: " + blogId);
            return blogId;
        } catch (Exception e) {
            logger.error(String.format("Error: %s has occurred attempting to save blog post", e));
            return -1;
        }
    }
}
