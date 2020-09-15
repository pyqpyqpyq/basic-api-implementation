package com.thoughtworks.rslist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    void should_get_arange_of_hs() throws Exception {
        mockMvc.perform(get("/hs/rg?a=1&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("[第一条事件, 第二条事件, 第三条事件]"));
    }


}
