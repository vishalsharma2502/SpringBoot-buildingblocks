package com.vishal.restservices.Hello;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserDetails {

    private String firstName;
    private String lastName;
    private String city;


}
