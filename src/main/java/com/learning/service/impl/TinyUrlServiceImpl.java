package com.learning.service.impl;

import com.learning.model.requestdto.UrlRequestDto;
import com.learning.model.responsedto.UrlResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.learning.service.TinyUrlService;

import reactor.core.publisher.Mono;

@Service
public class TinyUrlServiceImpl implements TinyUrlService {

	@Autowired
	private WebClient.Builder webClientBuilder;

	@Value("${url.external.api}")
	private String externalApiUrl;

	@Value("${url.auth.token}")
	private String bearerToken;

	private static final Logger logger = LoggerFactory.getLogger(TinyUrlServiceImpl.class);

	@Override
	public Mono<String> getDataFromExternalApi(UrlRequestDto urlRequestDto) {
		logger.info("calling external url{}", externalApiUrl);
		return webClientBuilder.build().post().uri(externalApiUrl)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + bearerToken)
				.body(Mono.just(urlRequestDto), UrlRequestDto.class).retrieve().bodyToMono(UrlResponseDto.class)
				.map(urlResponseDto -> urlResponseDto.getData().getTinyUrl());
	}
}
