package com.thoughtworks.rslist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RsListApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_a_hs() throws Exception {
        mockMvc.perform(get("/hs/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("第一条事件"));
        mockMvc.perform(get("/hs/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("第二条事件"));
        mockMvc.perform(get("/hs/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("第三条事件"));
    }

    @Test
    void should_get_range_of_hs() throws Exception {
        mockMvc.perform(get("/hs/rg?a=1&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("[第一条事件, 第二条事件, 第三条事件]"));
    }

    @Test
    void should_add_a_hs() throws Exception {
        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

        mockMvc.perform(post("/hs/event").content("{\"eventName\":\"猪肉涨价了\",\"keyword\":\"经济\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }


}
