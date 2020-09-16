package com.thoughtworks.rslist.api;

import com.thoughtworks.rslist.dto.UserDto;
import javassist.tools.web.BadHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<UserDto> userDtos=new ArrayList<>();

    @PostMapping("/user/register")
    public void register(@Valid @RequestBody UserDto userDto){
        userDtos.add(userDto);

        }
    }

