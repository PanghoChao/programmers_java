package step2;

import java.util.Arrays;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Solution5 s = new Solution5();
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };
		int[][] arr12 = { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } };
		int[][] arr22 = { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } };

		int[][] answer = s.solution(arr1, arr2);
		System.out.println(Arrays.deepToString(answer));

		int[][] answer2 = s.solution(arr12, arr22);
		System.out.println(answer2.toString());

	}
}

class Solution5 {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		System.out.println(Arrays.deepToString(answer));
		for (int i = 0; i < arr1.length; i++) {
			int m = 0;
			while (m < arr2[0].length) {
				for (int j = 0; j < arr1[0].length; j++) {
					answer[i][m] += arr1[i][j] * arr2[j][m];
				}
				m++;
			}

		}
		return answer;
	}
}
