package com.doughdesgin.doughmanagement.controllers;

import com.doughdesgin.doughmanagement.services.DoughDevService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoughDevController {
    private final Logger logger;
    private DoughDevService doughDevService;

    @Autowired
    DoughDevController(Logger logger, DoughDevService doughDevService) {
        this.logger = logger;
        this.doughDevService = doughDevService;
    }

    @GetMapping("api/doughdev/log")
    public void logMessage() {
        logger.info("Test logger message");
    }

    @GetMapping("api/doughdev/findBlog")
    public String findBlog() {
        return this.doughDevService.findBlog();
    }

}
