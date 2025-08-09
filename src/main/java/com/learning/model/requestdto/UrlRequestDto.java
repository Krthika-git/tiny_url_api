package com.learning.model.requestdto;

import org.springframework.beans.BeanUtils;

import com.learning.model.UrlParams;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlRequestDto {

	@JsonProperty("url")
	String url;
	@JsonProperty("domain")
	String domain;

	public UrlParams convertToModel() {

		UrlParams urlParams = new UrlParams();
		BeanUtils.copyProperties(this, urlParams);
		return urlParams;
	}
}
