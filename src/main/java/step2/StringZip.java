package step2;

//기능정리 
/*
1. 문자단위 자르기(1~문자열 반크기만큼)
2. 남는 문자열 더해주기 
3. 단위 반복되는 문자열 압축하기
4. 반복횟수가 1일경우 생략하기
*/
import java.util.Stack;

public class StringZip {
	public static void main(String[] args) {
		Solution2 s = new Solution2();
		String a = "aabbaccc";
		String b = "ababcdcdababcdcd";
		String c = "abcabcdede";
		String d = "abcabcabcabcdededededede";
		String e = "xababcdcdababcdcd";
		System.out.println(s.solution(a));
		System.out.println(s.solution(b));
		System.out.println(s.solution(c));
		System.out.println(s.solution(d));
		System.out.println(s.solution(e));
	}
}
//문자열을 큰 단위로 자를 수록 숫자가 작아진다.
//제일 앞부터 반복되는 길이만큼 동일하게 나눠야한다. 
//기능 정리 
//문자열을 1자리, 2자리 ... 점점 늘려가며 짜른다. 
//저장해야되는 것 단위문자열, 카운트숫자 

class Solution2 {
	public int solution(String s) {
		int answer = s.length();
		int len = s.length()/2;
		for(int i= 1; i <=len; i++ ) {
			answer= Math.min(unitZip(i,s).length(),answer);
		}

		return answer;
	}
	
	private String unitZip(int unit, String s) {
		String remaindString = "";
		String loopString = "";
		int remaind = s.length()%unit;
		if(remaind!=0) {
			remaindString += s.substring(s.length()-remaind, s.length());
		}
		loopString = loopString(unit,s);
		return loopString + remaindString;
		
	}

	private String loopString(int unit, String s) {
		Stack<String> loopString = new Stack<>();
		Stack<Integer> countString = new Stack<>();
		String finalString="";
		for(int i =0; i<=s.length()-unit;i= i+unit) {
			String unitString = s.substring(i, i+unit);
			
			if(loopString.isEmpty()) {
				loopString.add(unitString);
				countString.add(1);
				continue;
			}
			String recentString= loopString.pop();
			if(recentString.equals(unitString)) {
				countString.add(countString.pop() + 1);
				loopString.add(unitString);
				continue;
			}
	
			String num= oneCheck(countString.pop());
			finalString =finalString + num + recentString;
			loopString.add(unitString);
			countString.add(1);
		
			
		}
		String recentString= loopString.pop();
		String num= oneCheck(countString.pop());
		finalString =finalString + num + recentString;
		return finalString;
	}
	
	private String oneCheck(Integer number) {
		if(number == 1) {
			return "";
		}
		return number.toString();
	}		
}
