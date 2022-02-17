package com.doughdesgin.doughmanagement.controllers;

import com.doughdesgin.doughmanagement.services.DoughDevService;
import com.doughdesgin.doughmanagement.services.DoughDevServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

public class DoughDevControllerTests {

    Logger logger;

    @Test
    void endpoint_returns_blog_post() {
        DoughDevService service = new DoughDevServiceImpl();
        DoughDevController controller = new DoughDevController(this.logger, service);

        String response = controller.findBlog();

        Assertions.assertEquals("Blog post returned", response);
    }
}
