package com.dk.lcs.service.dto;

import java.util.List;

import javax.annotation.Nullable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class LongestCommonSubStringResponseDTO {
	
	@Nullable
	private List<LongestCommonSubStringDTO> lcs;
	@Nullable
	private ResponseErrorDTO error;
}
