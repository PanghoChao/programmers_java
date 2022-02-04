package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MinimumValue {
	public static void main(String[] args) {
		Solution8 s = new Solution8();
		int[] A1 = {1, 4, 2};
		int[] B1 = {5, 4, 4};
		int[] A2 = {1, 2};
		int[] B2 = {3, 4};
		int[] A3 = {5,8, 5, 6};
		int[] B3 = {4, 1, 1, 1};
		System.out.println(s.solution(A1, B1));
		System.out.println(s.solution(A2, B2));
		System.out.println(s.solution(A3, B3));
	}
}

//최솟값 만들기 좋은 방법은, A에서는 가장 작은값을, B에서는 가장 큰값을 꺼내어
//이둘을 곱해주고,나온값을 누적하여 배열 길이 만큼 반복한다. 
//그럼 최솟값
class Solution8
{
    public int solution(int []A, int []B)
    {

    	int answer = 0;
    	ArrayList<Integer> listA = new ArrayList<>(Arrays.stream(A).boxed().collect(Collectors.toList()));
    	ArrayList<Integer> listB = new ArrayList<>(Arrays.stream(B).boxed().collect(Collectors.toList()));
    	while(listA.size() != 0){
	    	int MaxA= Collections.max(listA);
	    	int MinB= Collections.min(listB);
	    	

	        answer += (MaxA *MinB);
			int indexA = listA.indexOf(MaxA);
			int indexB = listB.indexOf(MinB);
			
			listA.remove(indexA);
			listB.remove(indexB);
//	        listA.remove(listA.indexOf(MaxA));
//	        listB.remove(listA.indexOf(MinB));	     

    	}

        return answer;
    }
}