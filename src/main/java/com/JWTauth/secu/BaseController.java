package com.JWTauth.secu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BaseController {

    @GetMapping()
    public String index(){
        return "<h1>Hello man</h1>";
    }
    @GetMapping("user")
    public String user(){
        return "<h1>Hello user</h1>";
    }
    @GetMapping("admin")
    public String admin(){
        return "<h1>Hello admin</h1>";
    }
}
