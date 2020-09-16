package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.dto.Hs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RsListControllerTests {

    @Autowired
    MockMvc mockMvc;

    //    @Test
//    void should_get_a_hs() throws Exception {
//        mockMvc.perform(get("/hs/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("第一条事件"));
//        mockMvc.perform(get("/hs/2"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("第二条事件"));
//        mockMvc.perform(get("/hs/3"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("第三条事件"));
//    }
//
//
//    @Test
//    void should_add_a_hs() throws Exception {
//        mockMvc.perform(get("/hs/list"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)));
//
//        mockMvc.perform(post("/hs/event").content("{\"eventName\":\"猪肉涨价了\",\"keyword\":\"经济\"}"))
//                .andExpect(status().isOk());
//
//        mockMvc.perform(get("/hs/list"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(4)));
//    }
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//        ALL Above based on the hot search is Class of String instead of Hs and has been
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    void should_add_hs() throws Exception {
        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));

        mockMvc.perform(post("/hs/event").content("{\"hs_name\":\"猪肉涨价了\",\"key\":\"经济\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].hs_name", is("第一条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")))
                .andExpect(jsonPath("$[2].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[2].key", is("无分类")))
                .andExpect(jsonPath("$[3].hs_name", is("猪肉涨价了")))
                .andExpect(jsonPath("$[3].key", is("经济")));
    }

    @Test
    void should_modified_hs() throws Exception {
        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].hs_name", is("第一条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")))
                .andExpect(jsonPath("$[2].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[2].key", is("无分类")));


        Hs hs = new Hs("哈哈", "传参成功");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(hs);
        mockMvc.perform(put("/hs/modify?id=1")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].hs_name", is("哈哈")))
                .andExpect(jsonPath("$[0].key", is("传参成功")))
                .andExpect(jsonPath("$[1].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")))
                .andExpect(jsonPath("$[2].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[2].key", is("无分类")));
    }

    @Test
    void should_delete_hs() throws Exception {
        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].hs_name", is("第一条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")))
                .andExpect(jsonPath("$[2].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[2].key", is("无分类")));


        mockMvc.perform(delete("/hs/delete/1")).andExpect(status().isOk());


        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")));
    }

    @Test
    void add_hs_with_user() throws Exception {
        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].hs_name", is("第一条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")))
                .andExpect(jsonPath("$[2].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[2].key", is("无分类")));

        Hs hs = new Hs("哈哈", "传参成功");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(hs);

        mockMvc.perform(put("/hs/addwithuser/1")
                .content(json))
                .andExpect(status().isOk());


        mockMvc.perform(get("/hs/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].hs_name", is("第二条事件")))
                .andExpect(jsonPath("$[0].key", is("无分类")))
                .andExpect(jsonPath("$[1].hs_name", is("第三条事件")))
                .andExpect(jsonPath("$[1].key", is("无分类")));
    }

    @Test
    void should_get_range_of_hs() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/hs/list")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(203, status);
    }

    @Test
    void should_no_add_a_rs_event_when_name_empty() throws Exception {
        Hs hs= new Hs(null,"异常");
        ObjectMapper objectMapper=new ObjectMapper();
        String json=objectMapper.writeValueAsString(hs);

        mockMvc.perform(post("/hs/event")
                .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error",is("invalid param")));
    }
}
