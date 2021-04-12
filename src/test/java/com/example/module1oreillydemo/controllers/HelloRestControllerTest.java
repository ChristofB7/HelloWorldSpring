package com.example.module1oreillydemo.controllers;

import com.example.module1oreillydemo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//start a test server on a random port
public class HelloRestControllerTests {
    //using SpringBootTest you can inject a fully configured TestRestTemplate
    private TestRestTemplate template;

    @Test
    public void greetWithoutName(){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest",Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, World!", response.getMessage());
    }

    //it appears that when testing a function you should use assertEquals

    @Test
    public void greetWithName(){
        //RestTemplate has getForObject - it takes a url and a class to convert it into
        //it gets the JSON data - 
        Greeting response = template.getForObject("/rest?name=ChristofDB",Greeting.class);
        assertEquals("Hello, ChristofDB!", response.getMessage());
    }
}
