package com.example.module1oreillydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    //I want this to respond to an HTTP get request
    // '/hello' is the html file name under templates and that will be used to show to user
    //@requestparam means that a value needs to be passed
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "world", required = false) String name,
                           Model model){
        //"user" is the HTML attribute and name is the Java variable
        model.addAttribute("user", name);
        //dependency injection - we want a Model -> I want it to take the name and pass it to a view.
        //The Model is an interface that creates a basic webpage
        return "hello";
    }
}
