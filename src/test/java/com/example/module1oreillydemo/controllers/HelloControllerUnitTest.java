package com.example.module1oreillydemo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerUnitTest {

    //This is a JUNIT test
    @Test
    public void sayHello(){
        HelloController controller = new HelloController();
        //the tricky part is the controller takes a model variable -what do we give the controller in this case?
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("World",model);
        //testing if the result was hello - which it should be it was hard coded
        assertEquals("hello", result);
        //testing if the user variable in model is World - which was assigned above
        assertEquals("World",model.asMap().get("user"));

        //this tests the controller in a vacuum - not as a part of a spring MVC package
    }
}
