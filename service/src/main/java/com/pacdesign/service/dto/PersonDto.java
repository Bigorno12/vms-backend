package com.pacdesign.service.dto;

import com.pacdesign.persistence.enumeration.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Roles roles;
}
