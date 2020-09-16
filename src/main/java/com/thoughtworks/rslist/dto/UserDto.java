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

import javax.persistence.MapKeyClass;
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
    @Max(80)
    private Integer age;
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "^1(/d){10}$")
    private String phone;
    private Integer vote = 10;


}
