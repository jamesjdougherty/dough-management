package com.doughdesgin.doughmanagement.controllers;

import com.doughdesgin.doughmanagement.services.DoughDevService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DoughDevController.class)
public class DoughDevControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoughDevService doughDevService;

    @MockBean
    private Logger logger;

    @BeforeEach
    void setup() {
    }

    @Test
    @DisplayName("GET returns a 200 response status")
    void endpoint_returns_blog_post() throws Exception {
        when(doughDevService.findBlog()).thenReturn("Valid blog post");
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/doughdev/findBlog"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
