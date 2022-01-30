package step2;

import java.util.ArrayList;
import java.util.Collections;

//기능정리 
/*
 0. 지도 한번씩 확인하기
 1. 상하좌우로 같은 숫자인지 판별하기 - 확인을 맞춰으면 0으로 전환 
 2. 원소의 값을 1씩 키우기
 3. 최대 면적값 구하기
 */
public class KakaofriendColoringBook {
	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int m1 =6 ;
		int n1 = 4;
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int m2 = 3 ;
		int n2 = 3;		
		int[][] picture2 = {{0,1,0},{1,1,0},{0,0,0}};

		
		int[] answer = s.solution(m1,n1, picture);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		int[] answer2 = s.solution(m2,n2, picture2);
		System.out.println(answer2[0]);
		System.out.println(answer2[1]);
	}
}
class Solution3 {
	public int[] solution(int m, int n, int[][] picture) {
		int [][] visit = new int[m][n]; 
		ArrayList<Integer> areaList = new ArrayList<>();
        for(int i=0; i<m ; i++) {
        	for(int j=0; j<n; j++) {
        		if(picture[i][j]!=0 && visit[i][j]==0) {//본 배열이 부셔지지않았기에 여기가 작동한다.
        			areaList.add(areaCheck(picture[i][j], picture,visit, i, j));
        		}
    		}
    	}
        
        int numberOfArea = areaList.size();
        int maxSizeOfOneArea = Collections.max(areaList);
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	private int areaCheck(int colorNumber,int[][] picture,int[][] visit, int i, int j){
		
		if (i< 0 || j < 0 || i>=picture.length || j >= picture[0].length
				||picture[i][j] != colorNumber||visit[i][j] != 0) {
			return 0;
		}
		
		int area = 1;
		visit[i][j] = 1;
		//진위여부만 파악하고, 면적은 동적할당으로 처리하는게 좋아보임
		area +=areaCheck(colorNumber, picture,visit,i+1,j);
		area +=areaCheck(colorNumber, picture,visit,i,j+1);
		area +=areaCheck(colorNumber, picture,visit,i-1,j);
		area +=areaCheck(colorNumber, picture,visit,i,j-1);
		
		return area;
	}
}