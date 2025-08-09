package com.learning.model.responsedto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.learning.model.UrlParams;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlResponseDto {

	private Data data;

	// Define getters and setters for other fields if needed

	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Data {
		private String domain;
		private String alias;
		private boolean deleted;
		private boolean archived;
		private Analytics analytics;
		private List<String> tags;
		@JsonProperty("created_at")
		private String createdAt;
		private String expiresAt;
		@JsonProperty("tiny_url")
		private String tinyUrl;
		private String url;
		private int code;
		private List<String> errors;

	}

	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Analytics {
		private boolean enabled;
		private boolean isPublic;

	}

	public UrlParams convertToModel() {

		UrlParams urlParams = new UrlParams();
		BeanUtils.copyProperties(urlParams, this);
		return urlParams;
	}

}
