package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.requestdto.UrlRequestDto;
import com.learning.service.TinyUrlService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
public class TinyUrlController {

	@Autowired
    private TinyUrlService tinyUrlService;

    @GetMapping("/external-api")
    public Mono<String> callExternalApi(@RequestBody UrlRequestDto urlRequestDto) {
        return tinyUrlService.getDataFromExternalApi(urlRequestDto);
    }
	
}
