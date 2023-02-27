package com.github.lsj8367.controller;

import com.github.lsj8367.service.TransactionParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final TransactionParentService transactionParentService;

    @GetMapping("/transaction/test")
    public ResponseEntity<?> test() {
        transactionParentService.size();
        return ResponseEntity.ok().build();
    }

}
