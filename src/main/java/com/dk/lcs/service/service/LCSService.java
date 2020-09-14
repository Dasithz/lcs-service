package com.dk.stringprocessorservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dk.stringprocessorservice.dto.InputStringDTO;
import com.dk.stringprocessorservice.dto.LongestCommonSubStringDTO;
import com.dk.stringprocessorservice.dto.LongestCommonSubStringResponseDTO;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class LCSService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LCSService.class);

	public static List<String> getLCS(List<String> inputs) {
		List<String> commonStringList = new ArrayList<String>();

		for (int i = 0; i < inputs.size(); i++) {
			for (int j = 0; j < inputs.size(); j++) {
				if (i != j) {
					String lcString = getLCSofTwoStrings(inputs.get(i), inputs.get(j));
					if (StringUtils.isNotBlank(lcString)) {
						LOGGER.info(String.format("LCS for %s and %s is %s", inputs.get(i), inputs.get(j), lcString));
						commonStringList.add(lcString);
					}else {
						LOGGER.info(String.format("LCS for %s and %s is not available", inputs.get(i), inputs.get(j)));
					}
				}
			}
		}
		return commonStringList;
	}

	public static LongestCommonSubStringResponseDTO getLCSResponse(List<InputStringDTO> inputStrings) {

		List<String> processableStrings = new ArrayList<String>();
		inputStrings.forEach(inputString -> processableStrings.add(inputString.getValue()));

		String mostRepeatedWord = Collections.max(getLCS(processableStrings), Comparator.comparing(String::length));

		List<LongestCommonSubStringDTO> lcsList = new ArrayList<LongestCommonSubStringDTO>();
		lcsList.add(LongestCommonSubStringDTO.builder().value(mostRepeatedWord).build());

		return LongestCommonSubStringResponseDTO.builder().lcs(lcsList).build();
	}

	public static String getLCSofTwoStrings(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();

		int max = 0;

		int[][] dp = new int[m][n];
		int endIndex = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {

					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}

					if (max < dp[i][j]) {
						max = dp[i][j];
						endIndex = i;
					}
				}

			}
		}
		return str1.substring(endIndex - max + 1, endIndex + 1);
	}
}
