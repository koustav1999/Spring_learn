package com.cognizant.server.main.helloworld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
//The @RestController annotation specifies this class will handle requests and produce responses following REST style. 
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World RESTful with Spring Boot";
    }  

 @GetMapping(path="/hello-world-bean")  
public HelloWorldBean helloWorldBean()  
{  
return new HelloWorldBean("Hello World"); //constructor of HelloWorldBean  
}  
@GetMapping(path="/hello-world/path-variable/{name}")  
public HelloWorldBean helloWorldPathVariable(@PathVariable String name)  
{  
return new HelloWorldBean(String.format("Hello World, %s", name)); //%s replace the name  
}  
}  