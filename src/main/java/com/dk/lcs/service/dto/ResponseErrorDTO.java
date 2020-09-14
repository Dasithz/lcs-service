package com.dk.lcs.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ResponseErrorDTO {
	
	private String code;
	private String message;
	
}
