package com.example.services.imp;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.dto.SodukuDto;
import com.example.services.SodokuService;

@Service
public class SodokuServiceImp implements SodokuService {

	public int[][] sdk;
	long startTime;

	public int[][] solveSodoku(int S[][]) {
		this.sdk = new int[9][9];
		startTime = System.currentTimeMillis();
		solve_sudoku(S, 0, 0);
		return this.sdk;
	}

	private void solve_sudoku(int S[][], int x, int y) {
		if (System.currentTimeMillis() - startTime > 5000) {
			return;
		}
		if (y == 9) {
			if (x == 8) {
				printSolution(S);
				return;
			} else {
				solve_sudoku(S, x + 1, 0);
			}
		} else if (S[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (feasible(S, x, y, k)) {
					S[x][y] = k;
					solve_sudoku(S, x, y + 1);
					S[x][y] = 0;
				}
			}
		} else {
			solve_sudoku(S, x, y + 1);
		}
	}

	private boolean feasible(int S[][], int x, int y, int k) {
		for (int i = 0; i < 9; i++) {
			if (S[x][i] == k)// check col
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (S[i][y] == k)// check row
				return false;
		}
		int a = x / 3, b = y / 3;
		for (int i = 3 * a; i < 3 * a + 3; i++) {
			for (int j = 3 * b; j < 3 * b + 3; j++) {
				if (S[i][j] == k)
					return false;
			}
		}
		return true;
	}

	private void printSolution(int S[][]) {
		for (int i = 0; i < S.length; i++) {
			for (int j = 0; j < S.length; j++) {
				sdk[j][i] = S[j][i];
//				System.out.print(" " + S[j][i] + " ");
//				if ((j + 1) % 3 == 0) {
//					System.out.print("|");
//				}
			}
//			System.out.println();
//			if ((i + 1) % 3 == 0) {
//				for (int k = 0; k < S.length; k++) {
//					System.out.print("---");
//				}
//				System.out.println();
//			}
		}
	}

	@Override
	public int[][] populateSdk(SodukuDto sodukuDto) {
		int[][] S = new int[9][9];
		S[0][0] = parseInteger(sodukuDto.getA0());
		S[1][0] = parseInteger(sodukuDto.getA1());
		S[2][0] = parseInteger(sodukuDto.getA2());
		S[3][0] = parseInteger(sodukuDto.getA3());
		S[4][0] = parseInteger(sodukuDto.getA4());
		S[5][0] = parseInteger(sodukuDto.getA5());
		S[6][0] = parseInteger(sodukuDto.getA6());
		S[7][0] = parseInteger(sodukuDto.getA7());
		S[8][0] = parseInteger(sodukuDto.getA8());

		S[0][1] = parseInteger(sodukuDto.getB0());
		S[1][1] = parseInteger(sodukuDto.getB1());
		S[2][1] = parseInteger(sodukuDto.getB2());
		S[3][1] = parseInteger(sodukuDto.getB3());
		S[4][1] = parseInteger(sodukuDto.getB4());
		S[5][1] = parseInteger(sodukuDto.getB5());
		S[6][1] = parseInteger(sodukuDto.getB6());
		S[7][1] = parseInteger(sodukuDto.getB7());
		S[8][1] = parseInteger(sodukuDto.getB8());

		S[0][2] = parseInteger(sodukuDto.getC0());
		S[1][2] = parseInteger(sodukuDto.getC1());
		S[2][2] = parseInteger(sodukuDto.getC2());
		S[3][2] = parseInteger(sodukuDto.getC3());
		S[4][2] = parseInteger(sodukuDto.getC4());
		S[5][2] = parseInteger(sodukuDto.getC5());
		S[6][2] = parseInteger(sodukuDto.getC6());
		S[7][2] = parseInteger(sodukuDto.getC7());
		S[8][2] = parseInteger(sodukuDto.getC8());

		S[0][3] = parseInteger(sodukuDto.getD0());
		S[1][3] = parseInteger(sodukuDto.getD1());
		S[2][3] = parseInteger(sodukuDto.getD2());
		S[3][3] = parseInteger(sodukuDto.getD3());
		S[4][3] = parseInteger(sodukuDto.getD4());
		S[5][3] = parseInteger(sodukuDto.getD5());
		S[6][3] = parseInteger(sodukuDto.getD6());
		S[7][3] = parseInteger(sodukuDto.getD7());
		S[8][3] = parseInteger(sodukuDto.getD8());

		S[0][4] = parseInteger(sodukuDto.getE0());
		S[1][4] = parseInteger(sodukuDto.getE1());
		S[2][4] = parseInteger(sodukuDto.getE2());
		S[3][4] = parseInteger(sodukuDto.getE3());
		S[4][4] = parseInteger(sodukuDto.getE4());
		S[5][4] = parseInteger(sodukuDto.getE5());
		S[6][4] = parseInteger(sodukuDto.getE6());
		S[7][4] = parseInteger(sodukuDto.getE7());
		S[8][4] = parseInteger(sodukuDto.getE8());

		S[0][5] = parseInteger(sodukuDto.getF0());
		S[1][5] = parseInteger(sodukuDto.getF1());
		S[2][5] = parseInteger(sodukuDto.getF2());
		S[3][5] = parseInteger(sodukuDto.getF3());
		S[4][5] = parseInteger(sodukuDto.getF4());
		S[5][5] = parseInteger(sodukuDto.getF5());
		S[6][5] = parseInteger(sodukuDto.getF6());
		S[7][5] = parseInteger(sodukuDto.getF7());
		S[8][5] = parseInteger(sodukuDto.getF8());

		S[0][6] = parseInteger(sodukuDto.getG0());
		S[1][6] = parseInteger(sodukuDto.getG1());
		S[2][6] = parseInteger(sodukuDto.getG2());
		S[3][6] = parseInteger(sodukuDto.getG3());
		S[4][6] = parseInteger(sodukuDto.getG4());
		S[5][6] = parseInteger(sodukuDto.getG5());
		S[6][6] = parseInteger(sodukuDto.getG6());
		S[7][6] = parseInteger(sodukuDto.getG7());
		S[8][6] = parseInteger(sodukuDto.getG8());

		S[0][7] = parseInteger(sodukuDto.getH0());
		S[1][7] = parseInteger(sodukuDto.getH1());
		S[2][7] = parseInteger(sodukuDto.getH2());
		S[3][7] = parseInteger(sodukuDto.getH3());
		S[4][7] = parseInteger(sodukuDto.getH4());
		S[5][7] = parseInteger(sodukuDto.getH5());
		S[6][7] = parseInteger(sodukuDto.getH6());
		S[7][7] = parseInteger(sodukuDto.getH7());
		S[8][7] = parseInteger(sodukuDto.getH8());

		S[0][8] = parseInteger(sodukuDto.getI0());
		S[1][8] = parseInteger(sodukuDto.getI1());
		S[2][8] = parseInteger(sodukuDto.getI2());
		S[3][8] = parseInteger(sodukuDto.getI3());
		S[4][8] = parseInteger(sodukuDto.getI4());
		S[5][8] = parseInteger(sodukuDto.getI5());
		S[6][8] = parseInteger(sodukuDto.getI6());
		S[7][8] = parseInteger(sodukuDto.getI7());
		S[8][8] = parseInteger(sodukuDto.getI8());
		return S;
	}

	private int parseInteger(Integer val) {
		return Objects.isNull(val) ? 0 : val;
	}

	@Override
	public boolean checkSdk(int[][] S) {
		int count = 0;
		int x = 0;
		int y = 0;
		for (int k = 1; k <= 9; k++) {
			y = 0;
			for (x = 0; x < 9; x++) {
				count = 0;
				for (int i = 0; i < 9; i++) {
					if (S[x][i] == k) {// check col
						count++;
						if (!checkSdk2(S, x, i, k)) {
							return false;
						}
					}
					if (count >= 2) {
						return false;
					}
				}
				for (int i = 0; i < 9; i++) {
					if (S[i][y] == k) {// check row
						count++;
						if (!checkSdk2(S, i, y, k)) {
							return false;
						}
					}
					if (count >= 2) {
						return false;
					}
				}
				y++;
			}
		}
		if (count >= 2) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkSdk2(int[][] S, int x, int y, int k) {
		int count = 0;
		int a = x / 3, b = y / 3;
		for (int i = 3 * a; i < 3 * a + 3; i++) {
			for (int j = 3 * b; j < 3 * b + 3; j++) {
				if (S[i][j] == k) {
					count++;
					if (count > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
