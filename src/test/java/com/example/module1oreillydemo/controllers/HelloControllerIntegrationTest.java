package com.example.module1oreillydemo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTests {
    @Autowired
    private MockMvc mvc;

    //learn more about mvc https://www.javatpoint.com/spring-mvc-tutorial
    //https://www.baeldung.com/integration-testing-in-spring

    @Test
    public void testHelloWithoutName() throws Exception{
        //get - turn it into plain text
        //make sure the mvc status is ok
        //test without the name means that the default value of World found in file HelloController.java
        mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                //changed this to be hax and in the HelloController to Haxe and it still passed.... misunderstanding
                .andExpect(model().attribute("user", is("World")));
    }

    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello").param("name", "ChristofB").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("Hello"))
                .andExpect(model().attribute("user",is("ChristofB")));
    }
}
