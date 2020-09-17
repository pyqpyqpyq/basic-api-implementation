package com.thoughtworks.rslist.userentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name="user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {




@Id
@GeneratedValue
private  Integer id;
        private String name;
@Column(name="name")
        private String gender;

        private Integer age;
        private String email;

        private String phone;
        private Integer votenum;



}
