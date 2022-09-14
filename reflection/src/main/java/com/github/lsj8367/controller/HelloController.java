package com.github.lsj8367.controller;

import com.github.lsj8367.dto.HelloRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<?> hello(@ModelAttribute final HelloRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getEmail());
        return ResponseEntity.ok().build();
    }

}
