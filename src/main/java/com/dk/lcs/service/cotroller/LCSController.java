package com.dk.lcs.service.cotroller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dk.lcs.service.dto.LongestCommonSubStringRequestDTO;
import com.dk.lcs.service.dto.LongestCommonSubStringResponseDTO;
import com.dk.lcs.service.service.LCSService;
import com.dk.lcs.service.util.ProcessResponse;
import com.dk.lcs.service.util.StatusCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;

@Api("Longest Common Substring API")
@RestController
public class LCSController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LCSController.class);

	@PostMapping("/lcs")
	public LongestCommonSubStringResponseDTO retrieveLCS(
			@Valid @RequestBody LongestCommonSubStringRequestDTO lcsRequest,  HttpServletResponse response) {
		try {
			if(lcsRequest.getSetOfStrings().isEmpty()) {
				return ProcessResponse.internalErrorPayload(StatusCode.ERRORCODE_INVALID_REQUEST,"Invalid Request.", response);
			}
			LOGGER.info(String.format("Initiated API :  %s , request payload : %s ", "/lcs", lcsRequest));
			return LCSService.getLCSResponse(lcsRequest.getSetOfStrings());
		} catch (Exception e) {			
			LOGGER.error(
					String.format("Error occured in :  %s , exception : %s", "/lcs", e));
			return ProcessResponse.internalErrorPayload(StatusCode.ERRORCODE_UNDEFINED,"Error Occured", response);
		}
	}

}
