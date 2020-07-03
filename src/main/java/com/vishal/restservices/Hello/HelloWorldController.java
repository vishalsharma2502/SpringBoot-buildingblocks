package com.vishal.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/userdetailsbean")
    public UserDetails userDetailsBeans(){
        return new UserDetails("vishal","sharma","delhi");
    }
}
