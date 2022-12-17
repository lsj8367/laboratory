package com.github.lsj8367.api;

import com.github.lsj8367.application.HelloService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record HelloController(HelloService helloService) {

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {

        int i = 0;
        while (true) {
            helloService.printAsync();
            i++;

            if (i == 100) {
                break;
            }
        }

        return ResponseEntity.ok(Map.of("data", "success"));
    }
}
