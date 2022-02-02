package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class FunctionDevelopment {
	public static void main(String[] args) {
		Solution7 s = new Solution7();
		int[] progresses1 = {93, 30, 55};
		int[] speeds1 = {1, 30, 5};
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(s.solution(progresses1, speeds1)));
		System.out.println(Arrays.toString(s.solution(progresses2, speeds2)));
	}
	

}
class Solution7 {
    public int[] solution(int[] progresses, int[] speeds) {
    	//Queue로 변환
    	Queue<Integer> progressQue = new LinkedList<>(Arrays.stream(progresses).boxed().collect(Collectors.toList()));
    	Queue<Integer> speedsQue = new LinkedList<>(Arrays.stream(speeds).boxed().collect(Collectors.toList()));
        ArrayList<Integer> answer = new ArrayList<>() ;
        int time = 1;
        int launch = 0;
    	while(true) {
    		int program= progressQue.peek();
    		int speed = speedsQue.peek();
    		
    		if((program +(speed*time)) >= 100) {
    			launch += 1;
    			progressQue.remove();
    			speedsQue.remove();
    		}
    		if((program +(speed*time)) < 100) {
    			time += 1;
    			if(launch > 0) {
    				answer.add(launch);
    			}
    			launch = 0;
    		}
    		if(progressQue.isEmpty()){
    			answer.add(launch);
    			break;
    		}
    		
    	}
    	

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}