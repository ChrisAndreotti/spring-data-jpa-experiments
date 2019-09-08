package com.candreotti.demo.controller;


import com.candreotti.demo.domain.HelloRequest;
import com.candreotti.demo.dto.HelloResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.candreotti.demo.service.HelloService;

@RestController
@RequestMapping(value = "/api/hello")
public class PocController {
    @Autowired
    private HelloService helloService;

    @GetMapping
    public ResponseEntity<HelloResponseDto> helloGet(
            @RequestParam String name,
            @RequestParam int age) {
        HelloResponseDto helloResponse = helloService.greeting(
                HelloRequest.builder()
                        .name(name)
                        .age(age)
                        .build());

        return ResponseEntity.ok()
                .body(helloResponse);
    }

    @PostMapping
    public ResponseEntity<HelloResponseDto> helloPost(@RequestBody HelloRequest request) {

        HelloResponseDto helloResponse = helloService.greeting(request);

        return ResponseEntity.ok()
                .body(helloResponse);
    }
}
