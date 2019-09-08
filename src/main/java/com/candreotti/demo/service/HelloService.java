package com.candreotti.demo.service;

import com.candreotti.demo.domain.HelloRequest;
import com.candreotti.demo.dto.HelloResponseDto;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.Collectors;

@Service
public class HelloService {
    public HelloResponseDto greeting(HelloRequest request) {
        final HelloResponseDto helloResponse = HelloResponseDto.builder()
                .message(String.format("Hello %s, you are %d years old. Welcome!", request.getName(), request.getAge()))
                .luckyNumbers(new Random().ints(3, 1, 99).boxed().collect(Collectors.toList()))
                .build();
        return helloResponse;
    }
}
