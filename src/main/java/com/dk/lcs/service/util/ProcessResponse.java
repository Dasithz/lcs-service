package com.dk.lcs.service.util;

import javax.servlet.http.HttpServletResponse;

import com.dk.lcs.service.dto.LongestCommonSubStringResponseDTO;
import com.dk.lcs.service.dto.ResponseErrorDTO;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ProcessResponse {

	public static LongestCommonSubStringResponseDTO internalErrorPayload(String statusCode, String message, HttpServletResponse response ) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		ResponseErrorDTO error = ResponseErrorDTO.builder().code(statusCode).message(message).build();
		return LongestCommonSubStringResponseDTO.builder().error(error).build();
	}
}
