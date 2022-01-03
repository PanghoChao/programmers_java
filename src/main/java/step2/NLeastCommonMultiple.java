package step2;

class NLeastCommonMultiple{
	public static void main(String[] args) {
		Solution a = new Solution();
		int[] b= {2,6,8,14};
		int[] c= {1,2,3};
		int[] d= {3, 4, 9, 16}; //2로 두번 나눠야하는데
		System.out.println(a.solution(b));
		System.out.println(a.solution(c));
		System.out.println(a.solution(d));
	}
	
}
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        for(int e:arr) {
            //최소 공배수를 구하는 공식
        	answer = twoMultiple(answer, e);
        }
        return answer;
       
    }
    public int twoMultiple(int num1, int num2) {
    	int factor = 1;
    	int mn= Math.min(num1, num2);
    	for(int i = 2; i<=mn; i++) {
    		if(num1 % i ==0 && num2% i==0) {
    			factor = factor * i;
    			num1 = num1/i;
    			num2 = num2/i;
    			i--;
    		}
    	}
    	return factor*num1*num2;
    }
}