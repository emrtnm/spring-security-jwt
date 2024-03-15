package com.emrtnm.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<?> home() {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Connection accepted.");
        return ResponseEntity.ok(response);
    }
}
