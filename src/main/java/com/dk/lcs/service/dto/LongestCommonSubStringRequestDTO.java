package com.dk.lcs.service.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class LongestCommonSubStringRequestDTO {
	private List<InputStringDTO> setOfStrings;
}
