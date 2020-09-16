package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void Should_register_user() throws Exception {

        UserDto userDto = new UserDto("Alibaba", "female", 20, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void name_should_not_empty() throws Exception {

        UserDto userDto = new UserDto("", "female", 20, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void name_should_less_than_8() throws Exception {

        UserDto userDto = new UserDto("alibababab", "female", 20, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void gender_should_not_null() throws Exception {

        UserDto userDto = new UserDto("alibaba", "", 20, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void age_should_not_null() throws Exception {

        UserDto userDto = new UserDto("alibaba", "male", null, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void age_should_not_less_8() throws Exception {

        UserDto userDto = new UserDto("alibaba", "male", 1, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void age_should_not_more_100() throws Exception {

        UserDto userDto = new UserDto("alibaba", "male", 111, "alibaba@twuc.com", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void email_format() throws Exception {

        UserDto userDto = new UserDto("alibaba", "male", 19, "hhh", "10123456789");

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void mobile_not_null() throws Exception {

        UserDto userDto = new UserDto("alibaba", "male", 19, "alibaba@twuc.com", null);

        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(userDto);

        mockMvc.perform(post("/user/register")
                .content(userDtoJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}

