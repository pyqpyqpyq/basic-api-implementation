package com.thoughtworks.rslist.dto;
// "userName": "xiaowang",
//         "age": 19,
//         "gender": "female",
//         "email": "a@thoughtworks.com",
//         "phone": 18888888888


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public UserDto(String name, String gender, Integer age, String email, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    private String name;
    private String gender;
    private Integer age;
    private String email;
    private String phone;
    private Integer vote=10;


}
