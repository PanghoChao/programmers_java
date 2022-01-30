package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class PrintStackAndQueue {
	public static void main(String[] args) {
		Solution6 s = new Solution6();
//		int[] priorities1 = {2, 1, 3, 2};
//		int location1= 2;
//		System.out.println(s.solution(priorities1, location1));
//		
//		int[] priorities2 = {1, 1, 9, 1, 1, 1};
//		int location2= 0;
//		System.out.println(s.solution(priorities2, location2));
//		
		
		int[] priorities3 = {9, 2, 1,2,4};
		int location3= 1;
		System.out.println(s.solution(priorities3, location3));
		

	}
}
class Solution6 {
    public int solution(int[] priorities, int location) {
    	Queue<Integer> queue = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList())); 
        int answer = 0;
		System.out.println(queue);

    	while(location >= 0) {
    		int max = Collections.max(queue);
    		int pop = queue.poll();

    		if(location > 0) {
    			if(pop == max){
    				answer ++;
    				location --;
    			}
    			if(pop < max) {
    				location --;
    				queue.offer(pop);    				
    			}
    		}
    		else {
    			if(pop == max){
    				answer++;
    				location--;
    				
    			}
    			if(pop < max) {
    				location = queue.size();//poll로 인해 하나가 빠져있는 상태
    				queue.offer(pop);    				
    			}
    		}
    	}      
    	return answer;
    }
   
}