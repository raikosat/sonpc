package com.example.services;

import com.example.dto.SodukuDto;

public interface SodokuService {

	int[][] solveSodoku(int S[][]);
	
	int[][] populateSdk(SodukuDto sodukuDto);
	
	boolean checkSdk(int S[][]);
}
