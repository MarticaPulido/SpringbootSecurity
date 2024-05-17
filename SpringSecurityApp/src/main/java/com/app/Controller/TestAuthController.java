package com.app.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
    
    @RestController
    @RequestMapping("/auth")
    @PreAuthorize("denyAll()")
    public class TestAuthController {
    
        @GetMapping("/inicio")
            public String inicio() {
            return "Conectado";
        }
    
        @GetMapping("/hello")
        @PreAuthorize("permitAll") 
        public String hello() {
            return "Hello world";
        }
        
        @GetMapping("/hello-secured")
        @PreAuthorize("hasAuthority('READ')")
        public String helloSecured() {return "Hello world Secured";}


        @GetMapping("/hello-secured2")
        @PreAuthorize("hasAuthority('CREATE')")
        public String helloSecured2() {return "Hello world Secured2";}
}
