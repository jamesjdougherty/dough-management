package com.doughdesgin.doughmanagement.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoughDevController {
    private final Logger logger;

    @Autowired
    DoughDevController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("api/doughdev/log")
    public void logMessage() {
        logger.info("Test logger message");
    }

}
