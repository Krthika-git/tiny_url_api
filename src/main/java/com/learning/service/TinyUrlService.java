/**
 * 
 */
package com.learning.service;

import com.learning.model.requestdto.UrlRequestDto;

import reactor.core.publisher.Mono;

/**
 * @author KarthikaJ
 *
 */
public interface TinyUrlService {

	 Mono<String> getDataFromExternalApi(UrlRequestDto urlRequestDto);}
