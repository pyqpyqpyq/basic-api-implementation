package com.thoughtworks.rslist.dto;
// "userName": "xiaowang",
//         "age": 19,
//         "gender": "female",
//         "email": "a@thoughtworks.com",
//         "phone": 18888888888


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

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

    @NotEmpty
    @Size(max = 8)
    private String name;
    @NotEmpty
    private String gender;
    @NotNull
    @Min(18)
    private Integer age;
    private String email;
    private String phone;
    private Integer vote = 10;


}
