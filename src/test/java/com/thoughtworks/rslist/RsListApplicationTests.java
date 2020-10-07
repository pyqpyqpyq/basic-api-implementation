package com.thoughtworks.rslist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.dto.Hs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode=DirtiesContext.ClassMode
.BEFORE_EACH_TEST_METHOD)
class RsListApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_update_rs_event() throws Exception {
        String updateRsEventJson=stringify(new RsEvent("第一条事件","分类1"));

        mockMvc.perform(put("/rs/event/1")
        .content(updateRsEventJson)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(updateRsEventJson));
    }

    @Test
    void should_delete_rs_event() throws Exception {
        String deleteRsEventJson=stringify(new RsEvent("第一条事件","无分类"));

        mockMvc.perform(delete("/rs/event/1")).andExpect(status()
        .isOk()).andExpect(content().string(deleteRsEventJson));
    }

    private String stringify(RsEvent rsevent) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writeValueAsString(rsevent);
    }

//    private RsEvent parse(String rsEventJson) throws JsonProcessingException {
//        ObjectMapper objectMapper=new ObjectMapper();
//        return objectMapper.readValue(rsEventJson,RsEvent.class);
//    }
}
